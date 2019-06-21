const KEY_W = 87;
const KEY_S = 83;
const KEY_A = 65;
const KEY_D = 68;
const KEY_C = 67;
const KEY_F = 70;

class FirstPersonControls {
    constructor(camera, domElement) {
        this.domElement = domElement || document.body;
        this.isLocked = false;
        this.camera = camera;

        // 初始化camera, 将camera放在pitchObject正中央
        camera.rotation.set(0, 0, 0);
        camera.position.set(0, 0, 0);

        // 将camera添加到pitchObject, 使camera沿水平轴做旋转, 并提升pitchObject的相对高度
        this.pitchObject = new THREE.Object3D();
        this.pitchObject.add(camera);
        this.pitchObject.position.y = 10;

        // 将pitObject添加到yawObject, 使camera沿竖直轴旋转
        this.yawObject = new THREE.Object3D();
        this.yawObject.add(this.pitchObject);


        this.moveForward = false;
        this.moveBackward = false;
        this.moveLeft = false;
        this.moveRight = false;
    }


    onPointerlockChange() {
        // console.log(this.domElement);
        this.isLocked = document.pointerLockElement === this.domElement;

    }


    onPointerlockError() {
        console.error('THREE.PointerLockControls: Unable to use Pointer Lock API');
    }

    onMouseMove(event) {
        if (this.isLocked) {
            let movementX = event.movementX || event.mozMovementX || event.webkitMovementX || 0;
            let movementY = event.movementY || event.mozMovementY || event.webkitMovementY || 0;

            this.yawObject.rotation.y -= movementX * 0.002;
            this.pitchObject.rotation.x -= movementY * 0.002;
            // 这一步的目的是什么
            this.pitchObject.rotation.x = Math.max(-Math.PI / 2, Math.min(Math.PI / 2, this.pitchObject.rotation.x));
        }
    }

    onKeyDown(event) {
        switch (event.keyCode) {
            case KEY_W:
                if (!checkState)
                    this.moveForward = true;
                break;
            case KEY_A:
                if (!checkState)
                    this.moveLeft = true;
                break;
            case KEY_S:
                if (!checkState)
                    this.moveBackward = true;
                break;
            case KEY_D:
                if (!checkState)
                    this.moveRight = true;
                break;
            case KEY_C:
                if (hinter1.style.display === 'block') {
                    checkState = true;
                    this.isLocked = false;
                    document.exitPointerLock();
                    console.log(tempStatueName);
                    $.ajax({
                        type: "post",  //数据提交方式（post/get）
                        url: "/statue/statueByName",  //提交到的url
                        data:{"statuename":tempStatueName},
                        dataType: "json",//返回的数据类型格式
                        success: function(msg){
                            if (msg.code === 200){
                                var statuename = document.getElementById("statuename");
                                statuename.innerText = msg.data.statuename;
                                var introduction = document.getElementById("introduction");
                                introduction.innerText = msg.data.introduction;
                                var likenumber = document.getElementById("likenumber");
                                likenumber.innerText= msg.data.likenumber;
                                var statueimg=document.getElementById("statueimg");
                                statueimg.setAttribute("src",msg.data.statueimgsrc);
                                var authorimg=document.getElementById("authorimg");
                                authorimg.setAttribute("src",msg.data.authorimgsrc);
                                var author=document.getElementById("authorname");
                                author.innerText=msg.data.author;
                                var authorintro=document.getElementById("authorintro");
                                authorintro.innerText=msg.data.authorintro;
                                $('#myModal').modal({
                                    keyboard: false,
                                    backdrop: 'static'
                                });
                             //   findCommentByStatuename()
                                return true;
                            }else {
                                alert("雕塑失败");
                            }
                        }
                    });





                    // $('#myModal').modal({
                    //     keyboard: false,
                    //     backdrop: 'static'
                    // });
                    this.domElement.removeEventListener('click', this.domElement.requestPointerLock);
                }
                break;

            case KEY_F:
                if (hinter2.style.display === 'block') {
                    this.isLocked = false;
                    document.exitPointerLock();
                    $('#myModal2').modal({
                        keyboard: false,
                        backdrop: 'static'
                    });
                    this.domElement.removeEventListener('click', this.domElement.requestPointerLock);
                }
                break;
        }
    }

    onKeyUp(event) {
        switch (event.keyCode) {
            case KEY_W:
                this.moveForward = false;
                break;
            case KEY_A:
                this.moveLeft = false;
                break;
            case KEY_S:
                this.moveBackward = false;
                break;
            case KEY_D:
                this.moveRight = false;
                break;
        }
    }

    update(delta) {
        var temp = this.domElement;

        $("#chatbtn").click(function () {
            checkState = true;
            this.isLocked = true;
            temp.removeEventListener('click', temp.requestPointerLock);
        });

        $("#closebtn").click(function () {
            checkState = false;
            this.isLocked = true;
            temp.requestPointerLock();
            temp.addEventListener('click', temp.requestPointerLock);
        });

        $("#closebtn2").click(function () {
            checkState = false;
            this.isLocked = true;
            temp.requestPointerLock();
            temp.addEventListener('click', temp.requestPointerLock);
        });

        $("#closebtn3").click(function () {
            checkState = false;
            this.isLocked = false;
            temp.addEventListener('click', temp.requestPointerLock);
            console.log(this.isLocked);
        });


        if (this.isLocked) {
            instructions.style.display = 'none';
            blocker.style.display = 'none';
        } else {

            blocker.style.display = 'block';
            instructions.style.display = '';
        }


        // 移动速度
        const moveSpeed = 100;

        // 确定移动方向
        let direction = new THREE.Vector3();
        direction.x = Number(this.moveRight) - Number(this.moveLeft);
        direction.z = Number(this.moveBackward) - Number(this.moveForward);
        direction.y = 0;


        // 移动方向向量归一化，使得实际移动的速度大小不受方向影响
        if (direction.x !== 0 || direction.z !== 0) {
            direction.normalize();
        }


        horizontalRaycaster = new THREE.Raycaster(new THREE.Vector3(), new THREE.Vector3(), 0, 10);


        rotation.copy(this.yawObject.getWorldDirection(new THREE.Vector3()).multiply(new THREE.Vector3(-1, 0, -1)));

        var m = new THREE.Matrix4();
        if (direction.z < 0) {
            if (direction.x < 0) {
                m.makeRotationY(Math.PI / 4);
            } else if (direction.x > 0) {
                m.makeRotationY(-Math.PI / 4);
            } else {
                m.makeRotationY(0);
            }
        } else if (direction.z > 0) {
            if (direction.x < 0) {
                m.makeRotationY(Math.PI / 4 * 3);
            } else if (direction.x > 0) {
                m.makeRotationY(-Math.PI / 4 * 3);
            } else {
                m.makeRotationY(Math.PI);
            }
        } else {
            if (direction.x < 0) {
                m.makeRotationY(Math.PI / 2);
            } else if (direction.x > 0) {
                m.makeRotationY(-Math.PI / 2);
            }
        }

        rotation.applyMatrix4(m);


        horizontalRaycaster.set(new THREE.Vector3(this.yawObject.position.x, this.yawObject.position.y + 10, this.yawObject.position.z), rotation);

        var horizontalIntersections = horizontalRaycaster.intersectObjects(scene.children, true);
        var horOnObject = horizontalIntersections.length > 0;

        if (!horOnObject) {
            hinter1.style.display = 'none';
            hinter2.style.display = 'none';
            // 移动距离等于速度乘上间隔时间delta
            if (this.moveForward || this.moveBackward) {
                this.yawObject.translateZ(moveSpeed * direction.z * delta);
            }
            if (this.moveLeft || this.moveRight) {
                this.yawObject.translateX(moveSpeed * direction.x * delta);
            }
        } else {
            if (horizontalIntersections[0].object.type === "statue") {
                tempStatueName = horizontalIntersections[0].object.name;
                hinter1.style.display = 'block';
            } else if (horizontalIntersections[0].object.name === "Model") {
                hinter2.style.display = 'block';
            }
        }


    }

    connect() {
        this.domElement.addEventListener('click', this.domElement.requestPointerLock);
        // 在函数后面添加bind(this)的目的是什么
        document.addEventListener('pointerlockchange', this.onPointerlockChange.bind(this), false);
        document.addEventListener('pointerlockerror', this.onPointerlockError.bind(this), false);
        document.addEventListener('mousemove', this.onMouseMove.bind(this), false);
        document.addEventListener('keydown', this.onKeyDown.bind(this), false);
        document.addEventListener('keyup', this.onKeyUp.bind(this), false);

    }
}
