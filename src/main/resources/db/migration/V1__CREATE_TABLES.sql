/*Создание всех таблиц*/
/*Таблица Роль пользователя*/
CREATE TABLE IF NOT EXISTS user_role(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name character varying(60) NOT NULL UNIQUE
) TABLESPACE pg_default;

/*Таблица Роль создателя*/
CREATE TABLE IF NOT EXISTS creator_role(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name character varying(60) NOT NULL UNIQUE
) TABLESPACE pg_default;

/*Таблица Тип отзыва*/
CREATE TABLE IF NOT EXISTS review_type(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name character varying(60) NOT NULL UNIQUE
) TABLESPACE pg_default;

/*Таблица Жанр видео-материала*/
CREATE TABLE IF NOT EXISTS video_genre(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name character varying(60) NOT NULL UNIQUE
) TABLESPACE pg_default;

/*Таблица Жанр музыки*/
CREATE TABLE IF NOT EXISTS music_genre(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name character varying(60) NOT NULL UNIQUE
) TABLESPACE pg_default;

/*Таблица Возрастной рейтинг*/
CREATE TABLE IF NOT EXISTS age_rating(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    rating character varying(10) NOT NULL UNIQUE
) TABLESPACE pg_default;

/*Таблица Страна*/
CREATE TABLE IF NOT EXISTS country(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name character varying(100) NOT NULL UNIQUE
) TABLESPACE pg_default;

/*Таблица Создатель*/
CREATE TABLE IF NOT EXISTS creator(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name character varying(60) NOT NULL,
    last_name character varying(60) NOT NULL,
    add_names character varying(100)
) TABLESPACE pg_default;

/*Таблица Жанр одного видео-материала*/
CREATE TABLE IF NOT EXISTS defined_video_genre(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    video_genre_id BIGINT NOT NULL,
    video_id BIGINT NOT NULL
) TABLESPACE pg_default;

/*Таблица Создатель одного видео-материала*/
CREATE TABLE IF NOT EXISTS defined_creator(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    video_id BIGINT NOT NULL,
    creator_id BIGINT NOT NULL,
    creator_role_id BIGINT NOT NULL
) TABLESPACE pg_default;

/*Таблица Музыка*/
CREATE TABLE IF NOT EXISTS music(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    music_genre_id BIGINT NOT NULL,
    name character varying(60) NOT NULL,
    group_name character varying(60) NOT NULL,
    duration time without time zone NOT NULL
) TABLESPACE pg_default;

/*Таблица Комментарий*/
CREATE TABLE IF NOT EXISTS comment(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    video_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    content text NOT NULL,
    like_count BIGINT,
    add_date date NOT NULL,
    output_state boolean NOT NULL
) TABLESPACE pg_default;

/*Таблица Пользователь*/
CREATE TABLE IF NOT EXISTS user_table(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    user_role_id BIGINT NOT NULL,
    name character varying(60) NOT NULL,
    last_name character varying(60) NOT NULL,
    add_names character varying(100),
    login character varying(60) NOT NULL UNIQUE,
    password character varying(60) NOT NULL,
    photo_path text NOT NULL
) TABLESPACE pg_default;

/*Таблица Отзыв*/
CREATE TABLE IF NOT EXISTS review(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    video_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    review_type_id BIGINT NOT NULL,
    content text NOT NULL,
    like_count BIGINT,
    add_date date NOT NULL,
    output_state BOOLEAN NOT NULL
) TABLESPACE pg_default;

/*Таблица Тайм-Код*/
CREATE TABLE IF NOT EXISTS time_code(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    music_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    video_id BIGINT NOT NULL,
    trek_start time without time zone NOT NULL,
    trek_end time without time zone NOT NULL,
    like_count BIGINT,
    add_date date NOT NULL,
    output_state boolean NOT NULL
) TABLESPACE pg_default;

/*Таблица Жалоба на отзыв*/
CREATE TABLE IF NOT EXISTS review_complaint(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    review_id BIGINT NOT NULL,
    content text NOT NULL,
    add_date date NOT NULL
) TABLESPACE pg_default;

/*Таблица Жалоба на комментарий*/
CREATE TABLE IF NOT EXISTS comment_complaint(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    comment_id BIGINT NOT NULL,
    content text NOT NULL,
    add_date date NOT NULL
) TABLESPACE pg_default;

/*Таблица Видео-материал*/
CREATE TABLE IF NOT EXISTS video(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    age_rating_id BIGINT NOT NULL,
    country_id BIGINT NOT NULL,
    duration time without time zone NOT NULL,
    name character varying(60) NOT NULL,
    release_year int,
    tagline character varying(255),
    description text NOT NULL,
    poster_path text NOT NULL,
    trailer_link text,
    add_date date
) TABLESPACE pg_default;






