package com.example.fantasy_football.model;

import lombok.Getter;

@Getter
public enum Position {
    // Goalkeepers
    GK("Goalkeeper", "GK"),

    // Defenders
    CB("Center Back", "DEF"),
    LB("Left Back", "DEF"),
    RB("Right Back", "DEF"),
    LWB("Left Wing Back", "DEF"),
    RWB("Right Wing Back", "DEF"),

    // Midfielders
    CDM("Central Defensive Midfielder", "MID"),
    CM("Central Midfielder", "MID"),
    CAM("Central Attacking Midfielder", "MID"),
    LM("Left Midfielder", "MID"),
    RM("Right Midfielder", "MID"),

    // Forwards
    LW("Left Winger", "FWD"),
    RW("Right Winger", "FWD"),
    ST("Striker", "FWD"),
    CF("Center Forward", "FWD");

    private final String fullName;
    private final String category;

    Position(String fullName, String category) {
        this.fullName = fullName;
        this.category = category;
    }

}
