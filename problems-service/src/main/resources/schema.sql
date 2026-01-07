create table if not exists users_problems(
    userId int references users(id) on delete cascade,
    problemId int references problem(id) on delete cascade,
    isDone boolean default false,
    isFlagged boolean default false,

    primary key (userId, problemId)
);