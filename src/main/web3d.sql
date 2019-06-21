CREATE SCHEMA web3d;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS comment;

CREATE TABLE IF NOT EXISTS user (
  id INT(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  gender VARCHAR (4),
  role INT(4),
  introduction VARCHAR(800),
  location VARCHAR(100),
  workplace VARCHAR(100),
  userimgsrc VARCHAR (100),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS comment(
  id INT(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(100) NOT NULL,
  statuename VARCHAR(100) NOT NULL,
  posttime VARCHAR(20),
  introduction VARCHAR(800) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS statue(
  statuename VARCHAR(100) NOT NULL,
  author VARCHAR(100),
  authorintro VARCHAR(800),
  introduction VARCHAR(800) NOT NULL,
  likenumber INT(10),
  authorimgsrc VARCHAR(200),
  statueimgsrc VARCHAR(200),
  PRIMARY KEY (statuename)
);

INSERT INTO statue(statuename, author,authorintro,introduction,likenumber,authorimgsrc,statueimgsrc) VALUES
('dawei','米开朗基罗·博那罗蒂','米开朗基罗·博那罗蒂（Michelangelo Buonarroti，1475年3月6日—1564年2月18日），又译“米开朗琪罗，意大利文艺复兴时期伟大的绘画家、雕塑家、建筑师和诗人，文艺复兴时期雕塑艺术最高峰的代表，与拉斐尔和达芬奇并称为文艺复兴后三杰。','《大卫》是1501—1504年间意大利雕塑家米开朗基罗·博那罗蒂创作的大理石雕塑，现收藏于意大利佛罗伦萨美术学院。此雕塑为大理石雕像，高3.96米，连基座高5.5米。该雕像展现了一个年轻有力的裸体男子形象，体态健美、神情坚定、肌肉饱满、有生命力，似乎能够感觉到人物身体血管的跳动，更突出了大卫作为一名英雄的高大形象。《大卫》体现了人体的神圣美与大卫即将迸发出的巨大热情，从而成为西方美术史上值得夸耀的男性裸体雕像之一。',1111,'/img/author/mikailangqiluo.jpeg','/img/statue/dawei.jpeg'),
('weinasi','阿历山德罗斯','亚历山德罗斯（前2世纪），古希腊著名的雕塑家。他所创作的《米洛斯的阿佛洛狄忒》大理石雕像， 高204厘米，创作时间大约为公元前150年左右。','《米洛斯的维纳斯》（又称《米洛斯的阿芙洛蒂忒》、《断臂的维纳斯》）是古希腊雕刻家阿历山德罗斯于公元前150年左右创作的大理石雕塑，现收藏于法国卢浮宫博物馆。雕像表现出的爱神维纳斯身材端庄秀丽，肌肤丰腴，美丽的椭圆形面庞，希腊式挺直的鼻梁，平坦的前额和丰满的下巴，平静的面容，流露出希腊雕塑艺术鼎盛时期沿袭下来的思想化传统。她那微微扭转的姿势，使半裸的身体构成一个十分和谐而优美的螺旋形上升体态，富有音乐的韵律感，充满了巨大的艺术魅力。',2222,'/img/author/unknown.jpeg','/img/statue/weinasi.jpeg');

INSERT INTO statue(statuename, author,authorintro,introduction,likenumber,authorimgsrc,statueimgsrc) VALUES
('shenglinvshen','未知','暂无介绍','奈姬是希腊神话中的胜利女神，传说她曾协助奥林匹斯众神战胜泰坦巨人，给人们带来了胜利。在西方艺术中常以身有双翼，携带橄榄枝、月桂枝，手持竖琴吟唱颂诗的形象出现。雕像原先是安放在萨莫色雷斯岛海边的石崖上。胜利女神身高2.44米。传说是纪念公元前306年国王德米特里战胜埃及托勒密舰队而建立的；也有考证是公元前2世纪作品，是公元前190年罗德岛人民为战胜叙利亚的舰队而立的纪念碑。',333,'/img/author/unknown.jpeg','/img/statue/shenglinvshen.jpg'),
('shengmulianzi','米开朗基罗·博那罗蒂','米开朗基罗·博那罗蒂（Michelangelo Buonarroti，1475年3月6日—1564年2月18日），又译“米开朗琪罗”，意大利文艺复兴时期伟大的绘画家、雕塑家、建筑师和诗人，文艺复兴时期雕塑艺术最高峰的代表，与拉斐尔和达芬奇并称为文艺复兴后三杰。','罗马圣彼得大教堂圣母怜子像（The Pity / La Pieta）是一尊纯白大理石像，高2.15米，底座宽1.68米，重3050公斤。米开朗琪罗雕刻与磨光此像花了两年时间，出自于米开朗琪罗之手的圣母怜子像完成于1499年。当时的米开朗琪罗刚满25岁。',44,'/img/author/mikailangqiluo.jpeg','/img/statue/shengmulianzi.jpg'),
('sixiangzhe','奥古斯特·罗丹','奥古斯特·罗丹是19世纪法国最有影响的雕塑家，他一生勤奋工作，敢于突破官方学院派的束缚，走自己的路，他善于吸收一切优良传统，对于古希腊雕塑的优美生动及对比的手法，理解非常深刻，其作品架构了西方近代雕塑与现代雕塑之间的桥梁，罗丹是西方雕塑史上一位划时代的人物。欧洲两千多年来传统雕塑艺术的集大成者、20世纪新雕塑艺术的创造者。','《思想者》（法语名：Le Penseur）是法国雕塑家奥古斯特·罗丹创作的雕塑，该模型在罗丹的指导下有多个雕塑，最主要的雕像为青铜，底座为大理石材料，现藏于巴黎博物馆。1880年制作的石膏模型，现藏于巴黎罗丹美术馆。《思想者》塑造了一个强有力的劳动男子沉浸在极度痛苦中的姿态。这件作品将深刻的精神内涵与完整的人物塑造融于一体，体现了罗丹雕塑艺术的基本特征。《思想者》是罗丹整体作品体系中的典范，也是对他充满神奇的艺术实践的体现和反映；更是对他所建构并整合人类艺术思想—罗丹艺术思想体系的见证。',5,'/img/author/aogusite.jpeg','/img/statue/sixiangzhe.jpeg'),
('chuisigaoluren','未知','暂无介绍','《垂死的高卢人》(Dying Gaul)，大理石复制品， 高约93厘米，现收藏于罗马卡庇托利美术馆，原作为青铜，约创作于公元前二世纪。雕像深刻地揭示出了一个处于垂危时刻的英雄的复杂情绪，表现出高卢人的勇敢好胜与强悍不屈的精神。',66,'/img/author/unknown.jpeg','/img/statue/chuisigaoluren.jpg'),
('zhitiebingzhe','米隆','生于伊柳塞拉，长期在雅典活动，是希腊古典时期名家之一。他擅长作青铜像，作品突破了古风时期雕刻的拘谨形式，把希腊雕刻艺术推向新的高峰。他善于把握人体的准确结构及其在运动中的变化关系，并达到精神和肉体的平衡和谐。被认为是希腊艺术黄金时期——古典时期的开创者。','《掷铁饼者》是希腊雕刻家米隆于约公元前450年雕刻的青铜雕塑，原作已经丢失，复制品现收藏于罗马国立博物馆、特尔梅博物馆、梵蒂冈博物馆。《掷铁饼者》取材于希腊现实生活中的体育竞技活动，刻画的是一名强健的男子在掷铁饼过程中具有表现力的瞬间。雕塑选择的铁饼摆回到最高点、即将抛出的一刹那，有着强烈的“引而不发”的吸引力。虽然是一件静止的雕塑，但艺术家把握住了从一种状态转换到另一种状态的关键环节，达到了使观众心理上获得“运动感”的效果，成为后世艺术创作的典范，也是研究古希腊雕刻的重要资料。',777,'/img/author/unknown.jpeg','/img/statue/zhitiebingzhe.jpeg');

INSERT INTO comment(username,statuename,posttime,introduction) VALUES
('test','dawei','20190620 11:11:11','真好看'),
('test','weinasi','20190620 20:20:20','好美呀');

INSERT INTO user(username, password, gender, role, introduction, location, workplace) VALUES
('test','test','男',1,'学生','上海','上海'),
('dongdong','dongdong','女',2,'白领','江苏','北京');