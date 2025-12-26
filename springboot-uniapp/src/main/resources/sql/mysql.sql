create table tea
(
    tea_id         bigint auto_increment
        primary key,
    tea_name       varchar(200)         not null,
    price          double               not null comment '售价',
    discount_price double               null comment '优惠价',
    introduce      varchar(1000)        null comment '介绍',
    category       varchar(100)         null comment '分类',
    created_time   datetime             not null,
    is_hot         tinyint(1) default 0 null comment '是否推荐'
)
    comment '茶饮';

create table tea_images
(
    tea_images_id bigint auto_increment
        primary key,
    tea_id        bigint       not null,
    img_url       varchar(250) not null
)
    comment '茶饮的图片';

create table user
(
    user_id      bigint auto_increment comment '用户id'
        primary key,
    username     varchar(50)  not null comment '用户名',
    password     varchar(100) null comment '密码',
    open_id      varchar(100) null comment '微信id',
    role         varchar(10)  not null comment '角色',
    created_time datetime     not null comment '创建时间 '
)
    comment '用户';

