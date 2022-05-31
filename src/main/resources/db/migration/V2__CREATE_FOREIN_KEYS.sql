/*Создание внешних ключей для всех таблиц*/
ALTER TABLE user_table ADD
    CONSTRAINT user_role_fk FOREIGN KEY (user_role_id) REFERENCES user_role (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE review
    ADD CONSTRAINT video_id_fk FOREIGN KEY (video_id) REFERENCES video (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE review
    ADD CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES user_table (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE review
    ADD CONSTRAINT review_type_id_fk FOREIGN KEY (review_type_id) REFERENCES review_type (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE defined_video_genre
    ADD CONSTRAINT video_genre_id_fk FOREIGN KEY (video_genre_id) REFERENCES video_genre (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE defined_video_genre
    ADD CONSTRAINT video_id_fk FOREIGN KEY (video_id) REFERENCES video (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE video
    ADD CONSTRAINT age_rating_id_fk FOREIGN KEY (age_rating_id) REFERENCES age_rating (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE review_complaint
    ADD CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES user_table (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE review_complaint
    ADD CONSTRAINT review_id_fk FOREIGN KEY (review_id) REFERENCES review (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE comment_complaint
    ADD CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES user_table (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE comment_complaint
    ADD CONSTRAINT comment_id_fk FOREIGN KEY (comment_id) REFERENCES comment (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE comment
    ADD CONSTRAINT video_id_fk FOREIGN KEY (video_id) REFERENCES video (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE comment
    ADD CONSTRAINT creator_id_fk FOREIGN KEY (creator_id) REFERENCES creator (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE time_code
    ADD CONSTRAINT music_id_fk FOREIGN KEY (music_id) REFERENCES music (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE time_code
    ADD CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES user_table (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE time_code
    ADD CONSTRAINT video_id_fk FOREIGN KEY (video_id) REFERENCES video (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE music
    ADD CONSTRAINT music_genre_id_fk FOREIGN KEY (music_genre_id) REFERENCES music_genre (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE defined_creator
    ADD CONSTRAINT video_id_fk FOREIGN KEY (video_id) REFERENCES video (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE defined_creator
    ADD CONSTRAINT creator_id_fk FOREIGN KEY (creator_id) REFERENCES creator (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

ALTER TABLE defined_creator
    ADD CONSTRAINT creator_role_id_fk FOREIGN KEY (creator_role_id) REFERENCES creator_role (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;