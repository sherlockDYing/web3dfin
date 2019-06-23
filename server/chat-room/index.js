var app = require('express')();
var http = require('http').createServer(app);
var io = require('socket.io')(http);

app.get('/', function(req, res){
    res.send('<h1>Hello world</h1>');
});



let connected_usr = [];

io.on('connection', function (socket) {
    console.log('client '+ socket.id + ' connected');


    let usrUUID = '';
    socket.on('login', (uuid) => {
        usrUUID = uuid;
        connected_usr.push(usrUUID);
        console.log('client '+ socket.id + ' connected');
        update_connected_usr();
    });
    socket.on('input', (msg) => {
        io.emit('output', {
            uuid: usrUUID,
            msg: msg
        });
    });

    socket.on('player', function (data) {
        data.socketid = usrUUID;
        socket.broadcast.emit('player', data);
    });

    socket.on('disconnect', function () {
        console.log('client ' + socket.id + ' disconnected');
        connected_usr.splice(connected_usr.indexOf(usrUUID), 1);
        socket.broadcast.emit('offline', {
            socketid: usrUUID});
        update_connected_usr();
    });


    function update_connected_usr() {
        io.emit('loadUsr', connected_usr);
    }
});

http.listen(8080, function(){
    console.log('listening on *:8080');
});
