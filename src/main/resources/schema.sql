DROP TABLE IF EXISTS `post`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `company`;
DROP TABLE IF EXISTS `user_application`;

CREATE TABLE `company` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
    `country` varchar(255) DEFAULT NULL,
    `region` varchar(255) DEFAULT NULL,
    `created_at` datetime(6) DEFAULT NULL,
    `modified_at` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `post` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `company_id` bigint DEFAULT NULL,
    `reward` bigint DEFAULT NULL,
    `contents` TEXT DEFAULT NULL,
    `position` varchar(255) DEFAULT NULL,
    `skill` varchar(255) DEFAULT NULL,
    `created_at` datetime(6) DEFAULT NULL,
    `modified_at` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY (`company_id`),
    CONSTRAINT FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
    `created_at` datetime(6) DEFAULT NULL,
    `modified_at` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_application` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `user_id` bigint DEFAULT NULL,
    `post_id` bigint DEFAULT NULL,
    `created_at` datetime(6) DEFAULT NULL,
    `modified_at` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
