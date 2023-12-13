package com.l06g06.shellshift;

import java.util.Arrays;
import java.util.List;

public enum Components {

    Title(new String[] {
            "      HHHHHHH      H                 HHH     HHH              HHHHHHH      H                  HHH            ",
            "    H       HHH  HH                   HHH     HHH           H       HHH  HH          H      HH HHH      H    ",
            "   H         HH  HH                    HH      HH          H         HH  HH         HHH    HH   HHH    HH    ",
            "   HH        H   HH                    HH      HH          HH        H   HH          H     HH          HH    ",
            "    HHH          HH                    HH      HH           HHH          HH                HH        HHHHHHHH",
            "   HH HHH        HH  HHH      HHH      HH      HH          HH HHH        HH  HHH   HHH     HHHHHH   HHHHHHHH ",
            "    HHH HHH      HH H HHH    H HHH     HH      HH           HHH HHH      HH H HHH   HHH    HHHHH       HH    ",
            "      HHH HHH    HHH   HHH  H   HHH    HH      HH             HHH HHH    HHH   HHH   HH    HH          HH    ",
            "        HHH HHH  HH     HH HH    HHH   HH      HH               HHH HHH  HH     HH   HH    HH          HH    ",
            "          HH HHH HH     HH HHHHHHHH    HH      HH                 HH HHH HH     HH   HH    HH          HH    ",
            "           HH HH HH     HH HHHHHHH     HH      HH                  HH HH HH     HH   HH    HH          HH    ",
            "            H H  HH     HH HH          HH      HH                   H H  HH     HH   HH    HH          HH    ",
            "  HHH        H   HH     HH HHHH    H   HH      HH         HHH        H   HH     HH   HH    HH          HH    ",
            " H  HHHHHHHHH    HH     HH  HHHHHHH    HHH H   HHH H     H  HHHHHHHHH    HH     HH   HHH H HH           HH   ",
            "H     HHHHH       HH    HH   HHHHH      HHH     HHH     H     HHHHH       HH    HH    HHH   HH               ",
            "H                       H                               H                       H                            ",
            " HH                    H                                 HH                    H                             ",
            "                      H                                                       H                              ",
            "                     H                                                       H                               "
    }, new String[] {} ,"Title"),

    Start(new String[]{
            " HHHHH                           ",
            "H     H HHHHH   HH   HHHHH  HHHHH",
            "H         H    H  H  H    H   H  ",
            " HHHHH    H   H    H H    H   H  ",
            "      H   H   HHHHHH HHHHH    H  ",
            "H     H   H   H    H H   H    H  ",
            " HHHHH    H   H    H H    H   H  "
    }, new String[] {
            " yyyyy                           ",
            "y     y yyyyy   yy   yyyyy  yyyyy",
            "y         y    y  y  y    y   y  ",
            " yyyyy    y   y    y y    y   y  ",
            "      y   y   yyyyyy yyyyy    y  ",
            "y     y   y   y    y y   y    y  ",
            " yyyyy    y   y    y y    y   y  "
    }, "Start"),

    Statistics(new String[] {
            " HHHHH                                                   ",
            "H     H HHHHH   HH   HHHHH H  HHHH  HHHHH H  HHHH   HHHH ",
            "H         H    H  H    H   H H        H   H H    H H     ",
            " HHHHH    H   H    H   H   H  HHHH    H   H H       HHHH ",
            "      H   H   HHHHHH   H   H      H   H   H H           H",
            "H     H   H   H    H   H   H H    H   H   H H    H H    H",
            " HHHHH    H   H    H   H   H  HHHH    H   H  HHHH   HHHH "
    }, new String[] {
            " yyyyy                                                   ",
            "y     y yyyyy   yy   yyyyy y  yyyy  yyyyy y  yyyy   yyyy ",
            "y         y    y  y    y   y y        y   y y    y y     ",
            " yyyyy    y   y    y   y   y  yyyy    y   y y       yyyy ",
            "      y   y   yyyyyy   y   y      y   y   y y           y",
            "y     y   y   y    y   y   y y    y   y   y y    y y    y",
            " yyyyy    y   y    y   y   y  yyyy    y   y  yyyy   yyyy "
    }, "Statistics"),

    Quit(new String[] {
            " HHHHH                ",
            "H     H H    H H HHHHH",
            "H     H H    H H   H  ",
            "H     H H    H H   H  ",
            "H   H H H    H H   H  ",
            "H    H  H    H H   H  ",
            " HHHH H  HHHH  H   H  "
    }, new String[] {
            " yyyyy                ",
            "y     y y    y y yyyyy",
            "y     y y    y y   y  ",
            "y     y y    y y   y  ",
            "y   y y y    y y   y  ",
            "y    y  y    y y   y  ",
            " yyyy y  yyyy  y   y  "
    }, "Quit"),

    Shop(new String[] {
            " HHHHH                      ",
            "H     H H    H  HHHH  HHHHH ",
            "H       H    H H    H H    H",
            " HHHHH  HHHHHH H    H H    H",
            "      H H    H H    H HHHHH ",
            "H     H H    H H    H H     ",
            " HHHHH  H    H  HHHH  H     "
    }, new String[] {
            " yyyyy                      ",
            "y     y y    y  yyyy  yyyyy ",
            "y       y    y y    y y    y",
            " yyyyy  yyyyyy y    y y    y",
            "      y y    y y    y yyyyy ",
            "y     y y    y y    y y     ",
            " yyyyy  y    y  yyyy  y     "
    }, "Shop"),
    
    RapidFire(new String[] {
            "HHHHHH                            HHHHHHH                ",
            "H     H   HH   HHHHH  H HHHHH     H       H HHHHH  HHHHHH",
            "H     H  H  H  H    H H H    H    H       H H    H H     ",
            "HHHHHH  H    H H    H H H    H    HHHHH   H H    H HHHHH ",
            "H   H   HHHHHH HHHHH  H H    H    H       H HHHHH  H     ",
            "H    H  H    H H      H H    H    H       H H   H  H     ",
            "H     H H    H H      H HHHHH     H       H H    H HHHHHH",
    }, new String[]{
            "yyyyyy                            yyyyyyy                ",
            "y     y   yy   yyyyy  y yyyyy     y       y yyyyy  yyyyyy",
            "y     y  y  y  y    y y y    y    y       y y    y y     ",
            "yyyyyy  y    y y    y y y    y    yyyyy   y y    y yyyyy ",
            "y   y   yyyyyy yyyyy  y y    y    y       y yyyyy  y     ",
            "y    y  y    y y      y y    y    y       y y   y  y     ",
            "y     y y    y y      y yyyyy     y       y y    y yyyyyy",
    }, "Rapid Fire"),

    ExtraLife(new String[]{
        "HHHHHHH                               H                      ",
        "H       H    H HHHHH HHHHH    HH      H       H HHHHHH HHHHHH",
        "H        H  H    H   H    H  H  H     H       H H      H     ",
        "HHHHH     HH     H   H    H H    H    H       H HHHHH  HHHHH ",
        "H         HH     H   HHHHH  HHHHHH    H       H H      H     ",
        "H        H  H    H   H   H  H    H    H       H H      H     ",
        "HHHHHHH H    H   H   H    H H    H    HHHHHHH H H      HHHHHH"
    }, new String[]{
        "yyyyyyy                               y                      ",
        "y       y    y yyyyy yyyyy    yy      y       y yyyyyy yyyyyy",
        "y        y  y    y   y    y  y  y     y       y y      y     ",
        "yyyyy     yy     y   y    y y    y    y       y yyyyy  yyyyy ",
        "y         yy     y   yyyyy  yyyyyy    y       y y      y     ",
        "y        y  y    y   y   y  y    y    y       y y      y     ",
        "yyyyyyy y    y   y   y    y y    y    yyyyyyy y y      yyyyyy"
    }, "Extra Life"),

    RapidFireIcon(new String[] {
            "  RRR",
            "  *QGR",
            "  **QR   RRR",
            "  RRR    *QGR",
            "         **QR",
            "         RRR",
            "    RRR",
            "    *QGR",
            "    **QR",
            "    RRR"

    }, new String[]{}, "Icon"),

    Bullet(new String[]{
            "RRR",
            "*QGR",
            "**QR",
            "RRR "
    }, new String[]{
            " RRR",
            "RGQ*",
            "RQ**",
            " RRR"
    }, "Bullet"),

    BulletEmpowered(new String[]{
            "RRR",
            "S*QR",
            "SS*R",
            "RRR "
    }, new String[]{
            " RRR",
            "RQ*S",
            "R*SS",
            " RRR"
    }, "Bullet"),
    
    HeartIcon(new String[] {
        "  RRRR   RRRR ",
        " RQQQQR R****R",
        "RQQGGQQRQQQQ**R",
        "RQGQQQQQQQQQ**R",
        "RQGQQQQQQQQQ**R",
        "RQQQQQQQQQQQ**R",
        " RQQQQQQQQQ**R ",
        "  RQQQQQQQ**R  ",
        "   RQQQQ***R   ",
        "    RQQ***R    ",
        "     R***R     ",
        "      R*R      ",
        "       R"
    }, new String[]{
            "  RR  RR",
            " RQQRRQ*R",
            " RQGQQQ*R",
            " RQQQQQ*R",
            "  RQQ**R",
            "   R**R",
            "    RR"
    }, "Icon"),

    Chell(new String[] {
        " AAAA          ",
        "ABBDCAAAAAAAA  ",
        "ABBDDCCCCCCCCA ",
        "ABBBDDDDDDDDDCA",
        " ABBACCCCCCCCCA",
        "ABBABBBBBBBBBBA",
        "ABBABBJJIBBJJBA",
        "ABBABJGEIIBGEJA",
        " AAAKIGFIIIGFIA",
        "   MLIIIIIIIIL ",
        "  MONLLLLLLLL  ",
        " MGPMNGGGGPNMJJ",
        " MIMOPGGGGGPIJ ",
        "  M***JJJJ**J  ",
        "   JJJ    JJJ  "
    }, new String[] {
        "          AAAA ",
        "  AAAAAAAACDBBA",
        " ACCCCCCCCDDBBA",
        "ACDDDDDDDDDBBBA",
        "ACCCCCCCCCABBA ",
        "ABBBBBBBBBBABBA",
        "ABJJBBIJJBBABBA",
        "AJEGBIIEGJBABBA",
        "AIFGIIIFGIKAAA ",
        " LIIIIIIIILM   ",
        "  LLLLLLLLNOM  ",
        "JJMNPGGGGNMPGM ",
        " JIPGGGGGPOMIM ",
        "  J**JJJJ***M  ",
        "  JJJ    JJJ   "
    }, "Chell Model"),

    GameOver(new String[] {
        "      S SSS                                                     S SSS                                       ",
        "    S  SSSS  S                                                S  SSSS                                       ",
        "   S  S  SSSS                                                S  S  SSS   SS                                 ",
        "  S  SS   SS                                                S  SS   SSS  SS                                 ",
        " S  SSS                                                    S  SSS    SSS  SS    SSS             SSS  SSSS   ",
        "SS   SS             SSSS    SSS SSSS SSSS       SSS       SS   SS     SS   SS    SSS     SSS     SSSS SSSS S",
        "SS   SS   SSS      S SSS  S  SSS SSSS SSS  S   S SSS      SS   SS     SS   SS     SSS   S SSS     SS   SSSS ",
        "SS   SS  SSSS  S  S   SSSS    SS  SSSS SSSS   S   SSS     SS   SS     SS   SS      SS  S   SSS    SS        ",
        "SS   SS S  SSSS  SS    SS     SS   SS   SS   SS    SSS    SS   SS     SS   SS      SS SS    SSS   SS        ",
        "SS   SSS    SS   SS    SS     SS   SS   SS   SSSSSSSS     SS   SS     SS   SS      SS SSSSSSSS    SS        ",
        " SS  SS     S    SS    SS     SS   SS   SS   SSSSSSS       SS  SS     SS   SS      SS SSSSSSS     SS        ",
        "  SS S      S    SS    SS     SS   SS   SS   SS             SS S      S    SS      S  SS          SS        ",
        "   SSS     S     SS    SS     SS   SS   SS   SSSS    S       SSS     S      SSSSSSS   SSSS    S   SSS       ",
        "    SSSSSSS       SSSSS SS    SSS  SSS  SSS   SSSSSSS         SSSSSSS        SSSSS     SSSSSSS     SSS      ",
        "      SSS          SSS   SS    SSS  SSS  SSS   SSSSS            SSS                     SSSSS               ",
        "                                                                                                            ",
        "                                                                                                            "
    }, new String[]{}, "Game Over"),
    
    Restart(new String[]{
            "GGGGGG                                         ",
            "G     G GGGGGG  GGGG  GGGGG   GG   GGGGG  GGGGG",
            "G     G G      G        G    G  G  G    G   G  ",
            "GGGGGG  GGGGG   GGGG    G   G    G G    G   G  ",
            "G   G   G           G   G   GGGGGG GGGGG    G  ",
            "G    G  G      G    G   G   G    G G   G    G  ",
            "G     G GGGGGG  GGGG    G   G    G G    G   G  "
    }, new String[]{
            "yyyyyy                                         ",
            "y     y yyyyyy  yyyy  yyyyy   yy   yyyyy  yyyyy",
            "y     y y      y        y    y  y  y    y   y  ",
            "yyyyyy  yyyyy   yyyy    y   y    y y    y   y  ",
            "y   y   y           y   y   yyyyyy yyyyy    y  ",
            "y    y  y      y    y   y   y    y y   y    y  ",
            "y     y yyyyyy  yyyy    y   y    y y    y   y  "
    }, "Restart"),
    
    MainMenu(new String[]{
        "G     G                    G     G                     ",
        "GG   GG   GG   G G    G    GG   GG GGGGGG G    G G    G",
        "G G G G  G  G  G GG   G    G G G G G      GG   G G    G",
        "G  G  G G    G G G G  G    G  G  G GGGGG  G G  G G    G",
        "G     G GGGGGG G G  G G    G     G G      G  G G G    G",
        "G     G G    G G G   GG    G     G G      G   GG G    G",
        "G     G G    G G G    G    G     G GGGGGG G    G  GGGG "
    }, new String[] {
        "y     y                    y     y                     ",
        "yy   yy   yy   y y    y    yy   yy yyyyyy y    y y    y",
        "y y y y  y  y  y yy   y    y y y y y      yy   y y    y",
        "y  y  y y    y y y y  y    y  y  y yyyyy  y y  y y    y",
        "y     y yyyyyy y y  y y    y     y y      y  y y y    y",
        "y     y y    y y y   yy    y     y y      y   yy y    y",
        "y     y y    y y y    y    y     y yyyyyy y    y  yyyy "
    }, "Main Menu"),

    Score(new String[] {
        " GGG  GGG  GGG  GGG  GGG  ",
        "G    G    G   G G  G G   G ",
        " GG  G    G   G GGG  GG   ",
        "   G G    G   G G G  G   G ",
        "GGG   GGG  GGG  G  G GGG  "
    }, new String[] {}, "Score"),
    
    Coin(new String[] {
            "   JJJJ   ",
            "  JGGGGJ  ",
            " JGyyyy*J ",
            " JGyGGy*J ",
            "JGyGyyJy*J",
            "JGyGyyJy*J",
            "JGyGyyJy*J",
            "JGyGyyJy*J",
            "JGyGyyJy*J",
            "JGyGyyJy*J",
            "JGyGyyJy*J",
            " JyyJJy*J ",
            " Jyyyyy*J ",
            "  J****J  ",
            "   JJJJ   "
    }, new String[]{
            "  HH  ",
            " HGQH",
            "HGQyQH",
            "HQQQ*H",
            " HQ*H",
            "  HH"
    }, "Coin"),

    SoftMonster( new String[] {
            "   JJJ   JJJ   ",
            "   JQJ   JQJ   ",
            "    JQJJJQJ    ",
            "JJ JQ*****QJ JJ",
            "JQJQ*******QJQJ",
            "J***JJ***JJ***J",
            "J**JGGJ*JGGJ**J",
            "J**JGJJ*JJGJ**J",
            " J**JJ***JJ**J ",
            " J*****J*****J ",
            " J***RRRRR***J ",
            " JR**JJJJJ**RJ ",
            "  JRRJ   JRRJ  ",
            " JRJJ     JJRJ ",
            " JJ         JJ "
    }, new String[]{}, "SoftMonster"),

    HardMonster( new String[]{
            "   JJJ   JJJ   ",
            "   JUJ   JUJ   ",
            "    JUJJJUJ    ",
            "JJ JUFFFFFUJ JJ",
            "JUJUFFFFFFFUJUJ",
            "JFFJJFFFFFJJFFJ",
            "JFFJGJFFFJGJFFJ",
            "JFFJGSJFJSGJFFJ",
            " JFFJJFFFJJFFJ ",
            " JFFFFFJFFFFFJ ",
            " JFFFEEEEEFFFJ ",
            " JEFFJJJJJFFEJ ",
            "  JEEJ   JEEJ  ",
            " JEJJ     JJEJ ",
            " JJ         JJ ",
    }, new String[]{}, "HardMonster"),

    Zero(new String[]{
            " GG ",
            "G  G",
            "G  G",
            "G  G",
            " GG"
    }, new String[]{}, "0"),

    One(new String[] {
            " GG ",
            "G G",
            "  G",
            "  G",
            "GGGG"
    }, new String[]{},"1"),

    Two(new String[]{
            " GG ",
            "G  G",
            "  G ",
            " G  ",
            "GGGG",
    }, new String[]{}, "2"),

    Three(new String[]{
            " GG",
            "G  G",
            "  GG",
            "G  G",
            " GG"
    }, new String[]{}, "3"),

    Four(new String[]{
            "G  G",
            "G  G",
            "GGGG",
            "   G",
            "   G"
    }, new String[]{}, "4"),

    Five(new String[]{
            "GGGG",
            "G",
            "GGG",
            "   G",
            "GGG"
    }, new String[]{}, "5"),

    Six(new String[]{
            " GGG",
            "G",
            "GGG",
            "G  G",
            " GG ",
    }, new String[]{}, "6"),

    Seven(new String[]{
            "GGGG",
            "   G",
            "   G",
            "  G",
            " G"
    }, new String[]{}, "7"),

    Eight(new String[]{
            " GG ",
            "G  G",
            " GG ",
            "G  G",
            " GG"
    }, new String[]{}, "8"),

    Nine(new String[]{
            " GG ",
            "G  G",
            " GGG",
            "   G",
            "GGG "
    }, new String[]{}, "9"),

    StarPowerUp(new String[] {
            "     H",
            "    HGH",
            "    HyH",
            "HHHHGy*HHHH",
            "HGGGyyyyy*H",
            " Hyyyyyy*H",
            "  HyyyyyH",
            "  HyyyyyH",
            " HGyHHHy*H",
            " HyH   H*H",
            " HH     HH"
    }, new String[]{}, "StarPowerUp"),

    BulletPowerUp(new String[] {
            "HHHHHHHHHHHH",
            "HNGGGGGGGGNH",
            "HGNNNNNNNNOH",
            "HGNNNNNVNNOH",
            "HGNNNNVVVNOH",
            "HGNRRRNVNNOH",
            "HGN*QGRNNNOH",
            "HGN**QRNNNOH",
            "HGNRRRNNNNOH",
            "HGNNNNNNNNOH",
            "HNOOOOOOOONH",
            "HHHHHHHHHHHH"
    }, new String[]{}, "BulletPowerUp"),

    SpeedPowerUp(new String[]{
            "          HH",
            "         HGH",
            "        HGH",
            "    HHHHGHNH",
            "    HQ*HHGH",
            "    H**HGHNH",
            "    H**HHHH",
            "    H****H",
            "  HHQ***RH",
            " HQQ***RRH",
            " H***RRRRH ",
            "  HHHHHHH"
    }, new String[]{}, "SpeedPowerUp"),
    Tutorial(new String[] {
            "HHHHHHH                                           ",
            "   H    H    H HHHHH  HHHH  HHHHH  H   HH   H     ",
            "   H    H    H   H   H    H H    H H  H  H  H     ",
            "   H    H    H   H   H    H H    H H H    H H     ",
            "   H    H    H   H   H    H HHHHH  H HHHHHH H     ",
            "   H    H    H   H   H    H H   H  H H    H H     ",
            "   H     HHHH    H    HHHH  H    H H H    H HHHHHH"
    }, new String[]{
            "yyyyyyy                                           ",
            "   y    y    y yyyyy  yyyy  yyyyy  y   yy   y     ",
            "   y    y    y   y   y    y y    y y  y  y  y     ",
            "   y    y    y   y   y    y y    y y y    y y     ",
            "   y    y    y   y   y    y yyyyy  y yyyyyy y     ",
            "   y    y    y   y   y    y y   y  y y    y y     ",
            "   y     yyyy    y    yyyy  y    y y y    y yyyyyy"
    }, "Tutorial"),

    ArrowUp(new String[]{
            "GGGGGGGGGGGGG",
            "G           G",
            "G           G",
            "G     G     G",
            "G    GGG    G",
            "G   G G G   G",
            "G     G     G",
            "G     G     G",
            "G     G     G",
            "G           G",
            "G           G",
            "GGGGGGGGGGGGG"
    }, new String[]{
            "yyyyyyyyyyyyy",
            "y           y",
            "y           y",
            "y     y     y",
            "y    yyy    y",
            "y   y y y   y",
            "y     y     y",
            "y     y     y",
            "y     y     y",
            "y           y",
            "y           y",
            "yyyyyyyyyyyyy"
    }, "ArrowUp"),

    ArrowLeft(new String[]{
            "GGGGGGGGGGGGG",
            "G           G",
            "G           G",
            "G    G      G",
            "G   G       G",
            "G  GGGGGGG  G",
            "G   G       G",
            "G    G      G",
            "G           G",
            "G           G",
            "G           G",
            "GGGGGGGGGGGGG"
    }, new String[]{
            "yyyyyyyyyyyyy",
            "y           y",
            "y           y",
            "y    y      y",
            "y   y       y",
            "y  yyyyyyy  y",
            "y   y       y",
            "y    y      y",
            "y           y",
            "y           y",
            "y           y",
            "yyyyyyyyyyyyy"
    }, "ArrowLeft"),
    ArrowRight(new String[]{
            "GGGGGGGGGGGGG",
            "G           G",
            "G           G",
            "G      G    G",
            "G       G   G",
            "G  GGGGGGG  G",
            "G       G   G",
            "G      G    G",
            "G           G",
            "G           G",
            "G           G",
            "GGGGGGGGGGGGG"
    }, new String[]{
            "yyyyyyyyyyyyy",
            "y           y",
            "y           y",
            "y      y    y",
            "y       y   y",
            "y  yyyyyyy  y",
            "y       y   y",
            "y      y    y",
            "y           y",
            "y           y",
            "y           y",
            "yyyyyyyyyyyyy"
    }, "ArrowRight"),
    SpaceBar(new String[]{
            "GGGGGGGGGGGGGGGGGGGGGGGGGGGGGG",
            "G                            G",
            "G                            G",
            "G   GGG GGGG  GG   GGG GGGG  G",
            "G  G    G  G G  G G    G     G",
            "G   GG  G  G GGGG G    GGG   G",
            "G     G GGG  G  G G    G     G",
            "G  GGG  G    G  G  GGG GGGG  G",
            "G                            G",
            "G                            G",
            "GGGGGGGGGGGGGGGGGGGGGGGGGGGGGG",

    }, new String[]{
            "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyy",
            "y                            y",
            "y                            y",
            "y   yyy yyyy  yy   yyy yyyy  y",
            "y  y    y  y y  y y    y     y",
            "y   yy  y  y yyyy y    yyy   y",
            "y     y yyy  y  y y    y     y",
            "y  yyy  y    y  y  yyy yyyy  y",
            "y                            y",
            "y                            y",
            "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyy",
    }, "SpaceBar"),

    Cloud(new String[]{
            "         HHHHH",
            "        HGGGGGH",
            "       HGGGGGGGGHH",
            "      HGGGGGGGGGGTH",
            "    HHTGGGGGGGGGGGH",
            " HHHGGGTGGGGGGGGTTTHH ",
            "HTGGGGGGTGGGGGGTGGGGTH",
            "HTTGGGGTTTTTTTTGGGGGGTH",
            " HTTTTTTTTTTTTTTTTTTTTH",
            "  HHHHHHHHHHHHHHHHHHHH",
    }, new String[]{}, "Cloud"),

    Platform(new String[] {
            "JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ",
            "MNOPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPONM",
            "MNOPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPONM",
            "JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ"
    }, new String[]{
            "JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ",
            "MNOPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPONM",
            "MNOPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPONM",
            "JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ"
    }, "Platform"),

    MonstersKilled(new String[]{
            "H     H                                                                                        ",
            "HH   HH  HHHH  H    H  HHHH  HHHHH HHHHHH HHHHH   HHHH     H    H H H      H      HHHHHH HHHHH ",
            "H H H H H    H HH   H H        H   H      H    H H         H   H  H H      H      H      H    H",
            "H  H  H H    H H H  H  HHHH    H   HHHHH  H    H  HHHH     HHHH   H H      H      HHHHH  H    H  H",
            "H     H H    H H  H H      H   H   H      HHHHH       H    H  H   H H      H      H      H    H",
            "H     H H    H H   HH H    H   H   H      H   H  H    H    H   H  H H      H      H      H    H  H",
            "H     H  HHHH  H    H  HHHH    H   HHHHHH H    H  HHHH     H    H H HHHHHH HHHHHH HHHHHH HHHHH ",

    }, new String[]{}, "MonstersKilled"),

    NumLives(new String[]{
            "H                            ",
            "H       H H    H HHHHHH  HHHH",
            "H       H H    H H      H" ,
            "H       H H    H HHHHH   HHHH   H",
            "H       H H    H H           H",
            "H       H  H  H  H      H    H  H",
            "HHHHHHH H   HH   HHHHHH  HHHH"
    }, new String[]{}, "NumLives"),
    
    CoinsCollected(new String[]{
          " HHHHH                                                                                         ",
          "H     H  HHHH  H H    H  HHHH      HHHH   HHHH  H      H      HHHHHH  HHHH  HHHHH HHHHHH HHHHH ",
          "H       H    H H HH   H H         H    H H    H H      H      H      H    H   H   H      H    H",
          "H       H    H H H H  H  HHHH     H      H    H H      H      HHHHH  H        H   HHHHH  H    H  H",
          "H       H    H H H  H H      H    H      H    H H      H      H      H        H   H      H    H",
          "H     H H    H H H   HH H    H    H    H H    H H      H      H      H    H   H   H      H    H  H",
          " HHHHH   HHHH  H H    H  HHHH      HHHH   HHHH  HHHHHH HHHHHH HHHHHH  HHHH    H   HHHHHH HHHHH ",
    }, new String[]{}, "CoinsCollected"),

    Highscores(new String[]{
            "H     H                                                          ",
            "H     H H  HHHH  H    H  HHHH   HHHH   HHHH  HHHHH  HHHHHH  HHHH ",
            "H     H H H    H H    H H      H    H H    H H    H H      H     ",
            "HHHHHHH H H      HHHHHH  HHHH  H      H    H H    H HHHHH   HHHH ",
            "H     H H H  HHH H    H      H H      H    H HHHHH  H           H",
            "H     H H H    H H    H H    H H    H H    H H   H  H      H    H",
            "H     H H  HHHH  H    H  HHHH   HHHH   HHHH  H    H HHHHHH  HHHH ",
    }, new String[]{}, "Highscores"),
    First(new String[]{
            " HH    HHH HHHHH",
            "H H   H      H",
            "  H    HH    H",
            "  H      H   H",
            "HHHH  HHH    H"
    }, new String[]{}, "First"),

    Second(new String[]{
            " HH   H   H HHH",
            "H  H  HH  H H  H",
            "  H   H H H H  H",
            " H    H  HH H  H",
            "HHHH  H   H HHH",
    }, new String[]{}, "Second"),

    Third(new String[]{
            " HH   HHH  HHH  ",
            "H  H  H  H H  H ",
            "  HH  HHH  H  H",
            "H  H  H  H H  H  ",
            " HH   H  H HHH "
    }, new String[]{}, "Third"),

    Fourth(new String[]{
            "H  H  HHHHH H  H",
            "H  H    H   H  H",
            "HHHH    H   HHHH",
            "   H    H   H  H",
            "   H    H   H  H"
    }, new String[]{}, "Fourth"),

    Fifth(new String[]{
            "HHHH  HHHHH H  H",
            "H       H   H  H",
            "HHH     H   HHHH",
            "   H    H   H  H",
            "HHH     H   H  H"
    }, new String[]{}, "Fifth"),
    MoreBullets(new String[]{


            "H     H",
            "HH   HH  HHHH  HHHHH  HHHHHH    HHHHH  H    H H      H      HHHHHH HHHHH  HHHH",
            "H H H H H    H H    H H         H    H H    H H      H      H        H   H",
            "H  H  H H    H H    H HHHHH     HHHHH  H    H H      H      HHHHH    H    HHHH",
            "H     H H    H HHHHH  H         H    H H    H H      H      H        H        H",
            "H     H H    H H   H  H         H    H H    H H      H      H        H   H    H",
            "H     H  HHHH  H    H HHHHHH    HHHHH   HHHH  HHHHHH HHHHHH HHHHHH   H    HHHH "


    }, new String[]{
            "y     y",
            "yy   yy  yyyy  yyyyy  yyyyyy    yyyyy  y    y y      y      yyyyyy yyyyy  yyyy",
            "y y y y y    y y    y y         y    y y    y y      y      y        y   y",
            "y  y  y y    y y    y yyyyy     yyyyy  y    y y      y      yyyyy    y    yyyy",
            "y     y y    y yyyyy  y         y    y y    y y      y      y        y        y",
            "y     y y    y y   y  y         y    y y    y y      y      y        y   y    y",
            "y     y  yyyy  y    y yyyyyy    yyyyy   yyyy  yyyyyy yyyyyy yyyyyy   y    yyyy "
    }, "MoreBullets"),
    
    MoreBulletsIcon(new String[]{
            " ",
            " ",
            "         V    ",
            "        VVV   ",
            "     RRR V    ",
            "     *QGR     ",
            "     **QR     ",
            "     RRR      "
    }, new String[]{}, "MoreBullets");

    private final String[] image;
    private final String[] imageSelected;
    private final String name;
    private static final List<Components> numbers = Arrays.asList(Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine);
    private static final List<Components> ordinalNumbers = Arrays.asList(First, Second, Third, Fourth, Fifth);
    Components(String[] image, String[] imageSelected, String name) {
        this.image = image;
        this.imageSelected = imageSelected;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String[] getImage() {
        return image;
    }

    public String[] getImageSelected() {
        return imageSelected;
    }

    public String[] getImage(String name) {
        for (Components c : Components.values()) {
            if (c.getName().equals(name)) {
                return c.getImage();
            }
        }
        return new String[]{ "não funcionou" };
    }


    public static List<Components> getNumbers() {
        return numbers;
    }

    public static List<Components> getOrdinalNumbers() {
        return ordinalNumbers;
    }
}
