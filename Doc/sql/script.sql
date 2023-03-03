create table expense_reports
(
    id             int auto_increment
        primary key,
    user_id        int         null,
    purchase_day   date        null,
    invoice_number varchar(48) null comment '发票税号',
    amount         decimal     null comment '报销金额',
    vendor         varchar(32) null comment '发票的开票方',
    category_id    int         null,
    invoice_pdf    int         null,
    created_time   timestamp   null,
    update_time    timestamp   null,
    del_Flag       int         null
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
    del_Flag    int                null,
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
    end_date    datetime null,
    fund_type   int      null,
    description int      null,
    del_Flag    int      null,
    constraint fund_id_uindex
        unique (id)
);

create table `group`
(
    id           int auto_increment
        primary key,
    name         varchar(32) null,
    manager      int         null,
    created_date datetime    null,
    del_Flag     int         null
);

create table group_projects
(
    id         int auto_increment
        primary key,
    group_id   int null,
    project_id int null,
    del_Flag   int null
);

create table group_users
(
    id       int auto_increment
        primary key,
    group_id int null,
    user_id  int null,
    del_Flag int null
);

create table project
(
    id           int auto_increment comment '主键'
        primary key,
    project_name char(32)      null,
    creator      int           null,
    status       int           not null comment '项目状态，0为正常，1为暂停报销，2为项目结束',
    total_cost   decimal       null,
    delFlag      int default 0 null,
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
    id       int auto_increment
        primary key,
    name     char(16) null,
    email    char(32) null,
    role     int      null,
    phone    char(12) null comment '手机号',
    passwd   char(16) null,
    del_Flag int      null,
    constraint user_id_uindex
        unique (id)
)
    comment '用户表' auto_increment = 2;

create table user_project_records
(
    id               int auto_increment
        primary key,
    user_id          int           null,
    project_id       int           null,
    participation_at datetime      null,
    del_flag         int default 0 null
);

