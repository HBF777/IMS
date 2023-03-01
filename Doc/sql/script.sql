create table apply_record
(
    id            int auto_increment
        primary key,
    apply_user    int      null,
    apply_project int      null,
    apply_fund    int      null,
    create_time   datetime null,
    update_time   datetime null,
    apply_amount  decimal  null,
    approver      int      null comment '审批人id',
    status        int      null,
    constraint apply_record_id_uindex
        unique (id)
);

create table file
(
    id          char(8) default '' not null comment 'id'
        primary key,
    path        varchar(100)       not null comment '相对路径',
    name        varchar(100)       null comment '文件名',
    suffix      varchar(10)        null comment '后缀',
    size        int                null comment '大小|字节B',
    `use`       char               null comment '用途|枚举[FileUseEnum]：course("C", "讲师"), TEACHER("T", "课程")',
    created_at  datetime(3)        null comment '创建时间',
    updated_at  datetime(3)        null comment '修改时间',
    shard_index int                null comment '已上传分片',
    shard_size  int                null comment '分片大小|B',
    shard_total int                null comment '分片总数',
    `key`       varchar(32)        null comment '文件标识',
    constraint key_unique
        unique (`key`),
    constraint path_unique
        unique (path)
)
    comment '文件';

create table fund
(
    id          int auto_increment
        primary key,
    name        char(32) null,
    creator     int      null,
    total_quota decimal  null comment '资金总额度',
    spend_quota decimal  null,
    deadline    datetime null,
    start_time  datetime null,
    status      int      null,
    constraint fund_id_uindex
        unique (id)
);

create table project
(
    id           int auto_increment comment '主键'
        primary key,
    project_name char(32) null,
    creator      int      null,
    status       int      not null comment '项目状态，0为正常，1为暂停报销，2为项目结束',
    total_cost   decimal  null,
    constraint project_id_uindex
        unique (id)
)
    auto_increment = 2;

create table project_role
(
    id         int auto_increment
        primary key,
    user_id    int null,
    project_id int null,
    class_id   int null,
    constraint project_role_id_uindex
        unique (id)
);

create table role_class
(
    id   int      null,
    name char(12) null
);

create table user
(
    id     int auto_increment
        primary key,
    name   char(16) null,
    email  char(32) null,
    role   int      null,
    phone  char(12) null comment '手机号',
    passwd char(16) null,
    constraint user_id_uindex
        unique (id)
)
    comment '用户表';


