CREATE TABLE `geographic_coordinate` (
	`country`	VARCHAR(8)	NULL,
	`area`	BIGINT	NULL,
	`state`	VARCHAR(16)	NULL,
	`city`	VARCHAR(16)	NULL,
	`town`	VARCHAR(16)	NULL,
	`grid_x`	INT	NULL,
	`grid_y`	INT	NULL,
	`longitude_hour`	INT	NULL,
	`longitude_minute`	INT	NULL,
	`longitude_second`	DOUBLE	NULL,
	`latitude_hour`	INT	NULL,
	`latitude_minute`	INT	NULL,
	`latitude_second`	DOUBLE	NULL,
	`langitude`	DOUBLE	NULL,
	`latitude`	DOUBLE	NULL
) ENGINE=InnoDB CHARSET=utf8;

CREATE TABLE `midfcstinfo_region` (
	`state`	VARCHAR(16)	NULL,
	`city`	VARCHAR(16)	NULL,
	`code`	VARCHAR(16)	NULL,
	`south_korea`	VARCHAR(2)	NULL
);

CREATE TABLE `vilagefcst` (
	`no`	INT	NOT NULL,
	`baseDate`	INT	NULL,
	`baseTime`	INT	NULL,
	`fcstDate`	INT	NULL,
	`fcstTime`	INT	NULL,
	`x`	INT	NULL,
	`y`	INT	NULL,
	`category`	VARCHAR(4)	NULL,
	`fcstValue`	VARCHAR(16)	NULL
);

CREATE TABLE `getMidTa` (
	`no`	INT	NOT NULL,
	`tmFc`	INT	NULL,
	`regId`	VARCHAR(16)	NULL,
	`taMin3`	INT	NULL,
	`taMin4` INT NULL,
	`taMin5` INT NULL,
	`taMin6` INT NULL,
	`taMin7` INT NULL,
	`taMin8` INT NULL,
	`taMin9` INT NULL,
	`taMin10` INT NULL,
	`taMin3Low`	INT	NULL,
    `taMin4Low` INT NULL,
    `taMin5Low` INT NULL,
    `taMin6Low` INT NULL,
    `taMin7Low` INT NULL,
    `taMin8Low` INT NULL,
    `taMin9Low` INT NULL,
    `taMin10Low` INT NULL,
	`taMin3High`	INT	NULL,
    `taMin4High` INT NULL,
    `taMin5High` INT NULL,
    `taMin6High` INT NULL,
    `taMin7High` INT NULL,
    `taMin8High` INT NULL,
    `taMin9High` INT NULL,
    `taMin10High` INT NULL,
	`taMax3`	INT	NULL,
    `taMax4` INT NULL,
    `taMax5` INT NULL,
    `taMax6` INT NULL,
    `taMax7` INT NULL,
    `taMax8` INT NULL,
    `taMax9` INT NULL,
    `taMax10` INT NULL,
    `taMax3Low`	INT	NULL,
    `taMax4Low` INT NULL,
    `taMax5Low` INT NULL,
    `taMax6Low` INT NULL,
    `taMax7Low` INT NULL,
    `taMax8Low` INT NULL,
    `taMax9Low` INT NULL,
    `taMax10Low` INT NULL,
	`taMax3High`	INT	NULL,
    `taMax4High` INT NULL,
    `taMax5High` INT NULL,
    `taMax6High` INT NULL,
    `taMax7High` INT NULL,
    `taMax8High` INT NULL,
    `taMax9High` INT NULL,
    `taMax10High` INT NULL
);

CREATE TABLE `getMidLandFcst` (
	`no`	INT	NOT NULL,
	`tmFc`	INT	NULL,
	`regId`	INT	NULL,
	`rnSt3Am`	INT	NULL,
	`rnSt3Pm`	INT	NULL,
    `rnst4Am` INT NULL,
    `rnst4Pm` INT NULL,
    `rnst5Am` INT NULL,
    `rnst5Pm` INT NULL,
    `rnst6Am` INT NULL,
    `rnst6Pm` INT NULL,
    `rnst7Am` INT NULL,
    `rnst7Pm` INT NULL,
	`rnSt8`	INT	NULL,
    `rnst9` INT NULL,
    `rnst10` INT NULL,
	`wf3Am`	VARCHAR(8)	NULL,
	`wf3Pm`	VARCHAR(8)	NULL,
    `wf4AM` VARCHAR(8) NULL,
    `wf4PM` VARCHAR(8) NULL,
    `wf5AM` VARCHAR(8) NULL,
    `wf5PM` VARCHAR(8) NULL,
    `wf6AM` VARCHAR(8) NULL,
    `wf6PM` VARCHAR(8) NULL,
    `wf7AM` VARCHAR(8) NULL,
    `wf7PM` VARCHAR(8) NULL,
	`wf8`	VARCHAR(8)	NULL.
    `wf9` VARCHAR(8) NULL,
    `wf10` VARCHAR(8) NULL
);

ALTER TABLE `vilagefcst` ADD CONSTRAINT `PK_VILAGEFCST2` PRIMARY KEY (
	`no`
);

ALTER TABLE `getMidTa` ADD CONSTRAINT `PK_GETMIDTA` PRIMARY KEY (
	`no`
);

ALTER TABLE `getMidLandFcst` ADD CONSTRAINT `PK_GETMIDLANDFCST` PRIMARY KEY (
	`no`
);

ALTER TABLE vilagefcst MODIFY no INT NOT NULL AUTO_INCREMENT;


