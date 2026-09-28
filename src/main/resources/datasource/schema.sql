PRAGMA foreign_keys = ON;
PRAGMA journal_mode = WAL;
PRAGMA synchronous = NORMAL;

CREATE TABLE IF NOT EXISTS `Preferences` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` VARCHAR(255) NOT NULL UNIQUE, `value` TEXT NOT NULL, `description` TEXT, `createdAt` DATETIME NOT NULL, `updatedAt` DATETIME NOT NULL);