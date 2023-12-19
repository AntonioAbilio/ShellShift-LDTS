package com.l06g06.shellshift;

import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.List;


public enum Components {

    Title(ImmutableList.of(
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
    ), ImmutableList.of("") ,"Title"),

    Start(ImmutableList.of(
            " HHHHH                           ",
            "H     H HHHHH   HH   HHHHH  HHHHH",
            "H         H    H  H  H    H   H  ",
            " HHHHH    H   H    H H    H   H  ",
            "      H   H   HHHHHH HHHHH    H  ",
            "H     H   H   H    H H   H    H  ",
            " HHHHH    H   H    H H    H   H  "
    ), ImmutableList.of(
            " yyyyy                           ",
            "y     y yyyyy   yy   yyyyy  yyyyy",
            "y         y    y  y  y    y   y  ",
            " yyyyy    y   y    y y    y   y  ",
            "      y   y   yyyyyy yyyyy    y  ",
            "y     y   y   y    y y   y    y  ",
            " yyyyy    y   y    y y    y   y  "
    ), "Start"),

    Statistics(ImmutableList.of(
            " HHHHH                                                   ",
            "H     H HHHHH   HH   HHHHH H  HHHH  HHHHH H  HHHH   HHHH ",
            "H         H    H  H    H   H H        H   H H    H H     ",
            " HHHHH    H   H    H   H   H  HHHH    H   H H       HHHH ",
            "      H   H   HHHHHH   H   H      H   H   H H           H",
            "H     H   H   H    H   H   H H    H   H   H H    H H    H",
            " HHHHH    H   H    H   H   H  HHHH    H   H  HHHH   HHHH "
    ), ImmutableList.of(
            " yyyyy                                                   ",
            "y     y yyyyy   yy   yyyyy y  yyyy  yyyyy y  yyyy   yyyy ",
            "y         y    y  y    y   y y        y   y y    y y     ",
            " yyyyy    y   y    y   y   y  yyyy    y   y y       yyyy ",
            "      y   y   yyyyyy   y   y      y   y   y y           y",
            "y     y   y   y    y   y   y y    y   y   y y    y y    y",
            " yyyyy    y   y    y   y   y  yyyy    y   y  yyyy   yyyy "
    ), "Statistics"),

    Quit(ImmutableList.of(
            " HHHHH                ",
            "H     H H    H H HHHHH",
            "H     H H    H H   H  ",
            "H     H H    H H   H  ",
            "H   H H H    H H   H  ",
            "H    H  H    H H   H  ",
            " HHHH H  HHHH  H   H  "
    ), ImmutableList.of(
            " yyyyy                ",
            "y     y y    y y yyyyy",
            "y     y y    y y   y  ",
            "y     y y    y y   y  ",
            "y   y y y    y y   y  ",
            "y    y  y    y y   y  ",
            " yyyy y  yyyy  y   y  "
    ), "Quit"),

    Shop(ImmutableList.of(
            " HHHHH                      ",
            "H     H H    H  HHHH  HHHHH ",
            "H       H    H H    H H    H",
            " HHHHH  HHHHHH H    H H    H",
            "      H H    H H    H HHHHH ",
            "H     H H    H H    H H     ",
            " HHHHH  H    H  HHHH  H     "
    ), ImmutableList.of(
            " yyyyy                      ",
            "y     y y    y  yyyy  yyyyy ",
            "y       y    y y    y y    y",
            " yyyyy  yyyyyy y    y y    y",
            "      y y    y y    y yyyyy ",
            "y     y y    y y    y y     ",
            " yyyyy  y    y  yyyy  y     "
    ), "Shop"),

    RapidFire(ImmutableList.of(
            "HHHHHH                            HHHHHHH                ",
            "H     H   HH   HHHHH  H HHHHH     H       H HHHHH  HHHHHH",
            "H     H  H  H  H    H H H    H    H       H H    H H     ",
            "HHHHHH  H    H H    H H H    H    HHHHH   H H    H HHHHH ",
            "H   H   HHHHHH HHHHH  H H    H    H       H HHHHH  H     ",
            "H    H  H    H H      H H    H    H       H H   H  H     ",
            "H     H H    H H      H HHHHH     H       H H    H HHHHHH"
    ), ImmutableList.of(
            "yyyyyy                            yyyyyyy                ",
            "y     y   yy   yyyyy  y yyyyy     y       y yyyyy  yyyyyy",
            "y     y  y  y  y    y y y    y    y       y y    y y     ",
            "yyyyyy  y    y y    y y y    y    yyyyy   y y    y yyyyy ",
            "y   y   yyyyyy yyyyy  y y    y    y       y yyyyy  y     ",
            "y    y  y    y y      y y    y    y       y y   y  y     ",
            "y     y y    y y      y yyyyy     y       y y    y yyyyyy"
    ), "Rapid Fire"),

    ExtraLife(ImmutableList.of(
        "HHHHHHH                               H                      ",
        "H       H    H HHHHH HHHHH    HH      H       H HHHHHH HHHHHH",
        "H        H  H    H   H    H  H  H     H       H H      H     ",
        "HHHHH     HH     H   H    H H    H    H       H HHHHH  HHHHH ",
        "H         HH     H   HHHHH  HHHHHH    H       H H      H     ",
        "H        H  H    H   H   H  H    H    H       H H      H     ",
        "HHHHHHH H    H   H   H    H H    H    HHHHHHH H H      HHHHHH"
    ), ImmutableList.of(
        "yyyyyyy                               y                      ",
        "y       y    y yyyyy yyyyy    yy      y       y yyyyyy yyyyyy",
        "y        y  y    y   y    y  y  y     y       y y      y     ",
        "yyyyy     yy     y   y    y y    y    y       y yyyyy  yyyyy ",
        "y         yy     y   yyyyy  yyyyyy    y       y y      y     ",
        "y        y  y    y   y   y  y    y    y       y y      y     ",
        "yyyyyyy y    y   y   y    y y    y    yyyyyyy y y      yyyyyy"
    ), "Extra Life"),

    RapidFireIcon(ImmutableList.of(
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

    ), ImmutableList.of(), "Icon"),

    Bullet(ImmutableList.of(
            "RRR",
            "*QGR",
            "**QR",
            "RRR "
    ), ImmutableList.of(
            " RRR",
            "RGQ*",
            "RQ**",
            " RRR"
    ), "Bullet"),

    BulletEmpowered(ImmutableList.of(
            "RRR",
            "S*QR",
            "SS*R",
            "RRR "
    ), ImmutableList.of(
            " RRR",
            "RQ*S",
            "R*SS",
            " RRR"
    ), "Bullet"),

    HeartIcon(ImmutableList.of(
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
    ), ImmutableList.of(
            "  RR  RR",
            " RQQRRQ*R",
            " RQGQQQ*R",
            " RQQQQQ*R",
            "  RQQ**R",
            "   R**R",
            "    RR"
    ), "Icon"),

    Chell(ImmutableList.of(
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
    ), ImmutableList.of(
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
    ), "Chell Model"),

    GameOver(ImmutableList.of(
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
    ), ImmutableList.of(), "Game Over"),

    Restart(ImmutableList.of(
            "GGGGGG                                         ",
            "G     G GGGGGG  GGGG  GGGGG   GG   GGGGG  GGGGG",
            "G     G G      G        G    G  G  G    G   G  ",
            "GGGGGG  GGGGG   GGGG    G   G    G G    G   G  ",
            "G   G   G           G   G   GGGGGG GGGGG    G  ",
            "G    G  G      G    G   G   G    G G   G    G  ",
            "G     G GGGGGG  GGGG    G   G    G G    G   G  "
    ), ImmutableList.of(
            "yyyyyy                                         ",
            "y     y yyyyyy  yyyy  yyyyy   yy   yyyyy  yyyyy",
            "y     y y      y        y    y  y  y    y   y  ",
            "yyyyyy  yyyyy   yyyy    y   y    y y    y   y  ",
            "y   y   y           y   y   yyyyyy yyyyy    y  ",
            "y    y  y      y    y   y   y    y y   y    y  ",
            "y     y yyyyyy  yyyy    y   y    y y    y   y  "
    ), "Restart"),

    MainMenu(ImmutableList.of(
        "G     G                    G     G                     ",
        "GG   GG   GG   G G    G    GG   GG GGGGGG G    G G    G",
        "G G G G  G  G  G GG   G    G G G G G      GG   G G    G",
        "G  G  G G    G G G G  G    G  G  G GGGGG  G G  G G    G",
        "G     G GGGGGG G G  G G    G     G G      G  G G G    G",
        "G     G G    G G G   GG    G     G G      G   GG G    G",
        "G     G G    G G G    G    G     G GGGGGG G    G  GGGG "
    ), ImmutableList.of(
        "y     y                    y     y                     ",
        "yy   yy   yy   y y    y    yy   yy yyyyyy y    y y    y",
        "y y y y  y  y  y yy   y    y y y y y      yy   y y    y",
        "y  y  y y    y y y y  y    y  y  y yyyyy  y y  y y    y",
        "y     y yyyyyy y y  y y    y     y y      y  y y y    y",
        "y     y y    y y y   yy    y     y y      y   yy y    y",
        "y     y y    y y y    y    y     y yyyyyy y    y  yyyy "
    ), "Main Menu"),

    Score(ImmutableList.of(
        " GGG  GGG  GGG  GGG  GGG  ",
        "G    G    G   G G  G G   G ",
        " GG  G    G   G GGG  GG   ",
        "   G G    G   G G G  G   G ",
        "GGG   GGG  GGG  G  G GGG  "
    ), ImmutableList.of(""), "Score"),

    Coin(ImmutableList.of(
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
    ), ImmutableList.of(
            "  HH  ",
            " HGQH",
            "HGQyQH",
            "HQQQ*H",
            " HQ*H",
            "  HH"
    ), "Coin"),

    SoftMonster( ImmutableList.of(
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
    ), ImmutableList.of(), "SoftMonster"),

    HardMonster( ImmutableList.of(
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
            " JJ         JJ "
    ), ImmutableList.of(), "HardMonster"),

    Zero(ImmutableList.of(
            " GG ",
            "G  G",
            "G  G",
            "G  G",
            " GG"
    ), ImmutableList.of(), "0"),

    One(ImmutableList.of(
            " GG ",
            "G G",
            "  G",
            "  G",
            "GGGG"
    ), ImmutableList.of(),"1"),

    Two(ImmutableList.of(
            " GG ",
            "G  G",
            "  G ",
            " G  ",
            "GGGG"
    ), ImmutableList.of(), "2"),

    Three(ImmutableList.of(
            " GG",
            "G  G",
            "  GG",
            "G  G",
            " GG"
    ), ImmutableList.of(), "3"),

    Four(ImmutableList.of(
            "G  G",
            "G  G",
            "GGGG",
            "   G",
            "   G"
    ), ImmutableList.of(), "4"),

    Five(ImmutableList.of(
            "GGGG",
            "G",
            "GGG",
            "   G",
            "GGG"
    ), ImmutableList.of(), "5"),

    Six(ImmutableList.of(
            " GGG",
            "G",
            "GGG",
            "G  G",
            " GG "
    ), ImmutableList.of(), "6"),

    Seven(ImmutableList.of(
            "GGGG",
            "   G",
            "   G",
            "  G",
            " G"
    ), ImmutableList.of(), "7"),

    Eight(ImmutableList.of(
            " GG ",
            "G  G",
            " GG ",
            "G  G",
            " GG"
    ), ImmutableList.of(), "8"),

    Nine(ImmutableList.of(
            " GG ",
            "G  G",
            " GGG",
            "   G",
            "GGG "
    ), ImmutableList.of(), "9"),

    StarPowerUp(ImmutableList.of(
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
    ), ImmutableList.of(), "StarPowerUp"),

    BulletPowerUp(ImmutableList.of(
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
    ), ImmutableList.of(), "BulletPowerUp"),

    SpeedPowerUp(ImmutableList.of(
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
     ), ImmutableList.of( ), "SpeedPowerUp"),
    Tutorial(ImmutableList.of(
            "HHHHHHH                                           ",
            "   H    H    H HHHHH  HHHH  HHHHH  H   HH   H     ",
            "   H    H    H   H   H    H H    H H  H  H  H     ",
            "   H    H    H   H   H    H H    H H H    H H     ",
            "   H    H    H   H   H    H HHHHH  H HHHHHH H     ",
            "   H    H    H   H   H    H H   H  H H    H H     ",
            "   H     HHHH    H    HHHH  H    H H H    H HHHHHH"
     ), ImmutableList.of(
            "yyyyyyy                                           ",
            "   y    y    y yyyyy  yyyy  yyyyy  y   yy   y     ",
            "   y    y    y   y   y    y y    y y  y  y  y     ",
            "   y    y    y   y   y    y y    y y y    y y     ",
            "   y    y    y   y   y    y yyyyy  y yyyyyy y     ",
            "   y    y    y   y   y    y y   y  y y    y y     ",
            "   y     yyyy    y    yyyy  y    y y y    y yyyyyy"
     ), "Tutorial"),

    ArrowUp(ImmutableList.of(
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
     ), ImmutableList.of(
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
     ), "ArrowUp"),

    ArrowLeft(ImmutableList.of(
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
     ), ImmutableList.of(
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
     ), "ArrowLeft"),
    ArrowRight(ImmutableList.of(
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
     ), ImmutableList.of(
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
     ), "ArrowRight"),
    SpaceBar(ImmutableList.of(
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
            "GGGGGGGGGGGGGGGGGGGGGGGGGGGGGG"

     ), ImmutableList.of(
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
            "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"
     ), "SpaceBar"),

    Cloud(ImmutableList.of(
            "         HHHHH",
            "        HGGGGGH",
            "       HGGGGGGGGHH",
            "      HGGGGGGGGGGTH",
            "    HHTGGGGGGGGGGGH",
            " HHHGGGTGGGGGGGGTTTHH ",
            "HTGGGGGGTGGGGGGTGGGGTH",
            "HTTGGGGTTTTTTTTGGGGGGTH",
            " HTTTTTTTTTTTTTTTTTTTTH",
            "  HHHHHHHHHHHHHHHHHHHH"
     ), ImmutableList.of( ), "Cloud"),

    Platform(ImmutableList.of(
            "JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ",
            "MNOPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPONM",
            "MNOPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPONM",
            "JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ"
     ), ImmutableList.of(
            "JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ",
            "MNOPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPONM",
            "MNOPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPONM",
            "JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ"
     ), "Platform"),

    MonstersKilled(ImmutableList.of(
            "H     H                                                                                        ",
            "HH   HH  HHHH  H    H  HHHH  HHHHH HHHHHH HHHHH   HHHH     H    H H H      H      HHHHHH HHHHH ",
            "H H H H H    H HH   H H        H   H      H    H H         H   H  H H      H      H      H    H",
            "H  H  H H    H H H  H  HHHH    H   HHHHH  H    H  HHHH     HHHH   H H      H      HHHHH  H    H  H",
            "H     H H    H H  H H      H   H   H      HHHHH       H    H  H   H H      H      H      H    H",
            "H     H H    H H   HH H    H   H   H      H   H  H    H    H   H  H H      H      H      H    H  H",
            "H     H  HHHH  H    H  HHHH    H   HHHHHH H    H  HHHH     H    H H HHHHHH HHHHHH HHHHHH HHHHH "

     ), ImmutableList.of( ), "MonstersKilled"),

    NumLives(ImmutableList.of(
            "H                            ",
            "H       H H    H HHHHHH  HHHH",
            "H       H H    H H      H" ,
            "H       H H    H HHHHH   HHHH   H",
            "H       H H    H H           H",
            "H       H  H  H  H      H    H  H",
            "HHHHHHH H   HH   HHHHHH  HHHH"
     ), ImmutableList.of( ), "NumLives"),

    CoinsCollected(ImmutableList.of(
          " HHHHH                                                                                         ",
          "H     H  HHHH  H H    H  HHHH      HHHH   HHHH  H      H      HHHHHH  HHHH  HHHHH HHHHHH HHHHH ",
          "H       H    H H HH   H H         H    H H    H H      H      H      H    H   H   H      H    H",
          "H       H    H H H H  H  HHHH     H      H    H H      H      HHHHH  H        H   HHHHH  H    H  H",
          "H       H    H H H  H H      H    H      H    H H      H      H      H        H   H      H    H",
          "H     H H    H H H   HH H    H    H    H H    H H      H      H      H    H   H   H      H    H  H",
          " HHHHH   HHHH  H H    H  HHHH      HHHH   HHHH  HHHHHH HHHHHH HHHHHH  HHHH    H   HHHHHH HHHHH "
     ), ImmutableList.of( ), "CoinsCollected"),

    Highscores(ImmutableList.of(
            "H     H                                                          ",
            "H     H H  HHHH  H    H  HHHH   HHHH   HHHH  HHHHH  HHHHHH  HHHH ",
            "H     H H H    H H    H H      H    H H    H H    H H      H     ",
            "HHHHHHH H H      HHHHHH  HHHH  H      H    H H    H HHHHH   HHHH ",
            "H     H H H  HHH H    H      H H      H    H HHHHH  H           H",
            "H     H H H    H H    H H    H H    H H    H H   H  H      H    H",
            "H     H H  HHHH  H    H  HHHH   HHHH   HHHH  H    H HHHHHH  HHHH "
     ), ImmutableList.of( ), "Highscores"),
    First(ImmutableList.of(
            " HH    HHH HHHHH",
            "H H   H      H",
            "  H    HH    H",
            "  H      H   H",
            "HHHH  HHH    H"
     ), ImmutableList.of( ), "First"),

    Second(ImmutableList.of(
            " HH   H   H HHH",
            "H  H  HH  H H  H",
            "  H   H H H H  H",
            " H    H  HH H  H",
            "HHHH  H   H HHH"
     ), ImmutableList.of( ), "Second"),

    Third(ImmutableList.of(
            " HH   HHH  HHH  ",
            "H  H  H  H H  H ",
            "  HH  HHH  H  H",
            "H  H  H  H H  H  ",
            " HH   H  H HHH "
     ), ImmutableList.of( ), "Third"),

    Fourth(ImmutableList.of(
            "H  H  HHHHH H  H",
            "H  H    H   H  H",
            "HHHH    H   HHHH",
            "   H    H   H  H",
            "   H    H   H  H"
     ), ImmutableList.of( ), "Fourth"),

    Fifth(ImmutableList.of(
            "HHHH  HHHHH H  H",
            "H       H   H  H",
            "HHH     H   HHHH",
            "   H    H   H  H",
            "HHH     H   H  H"
     ), ImmutableList.of( ), "Fifth"),
    MoreBullets(ImmutableList.of(


            "H     H",
            "HH   HH  HHHH  HHHHH  HHHHHH    HHHHH  H    H H      H      HHHHHH HHHHH  HHHH",
            "H H H H H    H H    H H         H    H H    H H      H      H        H   H",
            "H  H  H H    H H    H HHHHH     HHHHH  H    H H      H      HHHHH    H    HHHH",
            "H     H H    H HHHHH  H         H    H H    H H      H      H        H        H",
            "H     H H    H H   H  H         H    H H    H H      H      H        H   H    H",
            "H     H  HHHH  H    H HHHHHH    HHHHH   HHHH  HHHHHH HHHHHH HHHHHH   H    HHHH "


     ), ImmutableList.of(
            "y     y",
            "yy   yy  yyyy  yyyyy  yyyyyy    yyyyy  y    y y      y      yyyyyy yyyyy  yyyy",
            "y y y y y    y y    y y         y    y y    y y      y      y        y   y",
            "y  y  y y    y y    y yyyyy     yyyyy  y    y y      y      yyyyy    y    yyyy",
            "y     y y    y yyyyy  y         y    y y    y y      y      y        y        y",
            "y     y y    y y   y  y         y    y y    y y      y      y        y   y    y",
            "y     y  yyyy  y    y yyyyyy    yyyyy   yyyy  yyyyyy yyyyyy yyyyyy   y    yyyy "
     ), "MoreBullets"),

    MoreBulletsIcon(ImmutableList.of(
            " ",
            " ",
            "         V    ",
            "        VVV   ",
            "     RRR V    ",
            "     *QGR     ",
            "     **QR     ",
            "     RRR      "
     ), ImmutableList.of( ), "MoreBullets"),

    SoundOFF(ImmutableList.of(
            " HHHHH  HHHHHHH H     H H     H HHHHHH     HHHHHHH HHHHHHH HHHHHHH",
            "H     H H     H H     H HH    H H     H    H     H H       H      ",
            "H       H     H H     H H H   H H     H    H     H H       H      ",
            " HHHHH  H     H H     H H  H  H H     H    H     H HHHHH   HHHHH  ",
            "      H H     H H     H H   H H H     H    H     H H       H      ",
            "H     H H     H H     H H    HH H     H    H     H H       H      ",
            " HHHHH  HHHHHHH  HHHHH  H     H HHHHHH     HHHHHHH H       H      "
     ), ImmutableList.of(
            " yyyyy  yyyyyyy y     y y     y yyyyyy     yyyyyyy yyyyyyy yyyyyyy",
            "y     y y     y y     y yy    y y     y    y     y y       y      ",
            "y       y     y y     y y y   y y     y    y     y y       y      ",
            " yyyyy  y     y y     y y  y  y y     y    y     y yyyyy   yyyyy  ",
            "      y y     y y     y y   y y y     y    y     y y       y      ",
            "y     y y     y y     y y    yy y     y    y     y y       y      ",
            " yyyyy  yyyyyyy  yyyyy  y     y yyyyyy     yyyyyyy y       y      "
     ), "SoundOFF"),

    SoundON(ImmutableList.of(
            " HHHHH  HHHHHHH H     H H     H HHHHHH     HHHHHHH H     H",
            "H     H H     H H     H HH    H H     H    H     H HH    H",
            "H       H     H H     H H H   H H     H    H     H H H   H",
            " HHHHH  H     H H     H H  H  H H     H    H     H H  H  H",
            "      H H     H H     H H   H H H     H    H     H H   H H",
            "H     H H     H H     H H    HH H     H    H     H H    HH",
            " HHHHH  HHHHHHH  HHHHH  H     H HHHHHH     HHHHHHH H     H"

     ), ImmutableList.of(
            " yyyyy  yyyyyyy y     y y     y yyyyyy     yyyyyyy y     y",
            "y     y y     y y     y yy    y y     y    y     y yy    y",
            "y       y     y y     y y y   y y     y    y     y y y   y",
            " yyyyy  y     y y     y y  y  y y     y    y     y y  y  y",
            "      y y     y y     y y   y y y     y    y     y y   y y",
            "y     y y     y y     y y    yy y     y    y     y y    yy",
            " yyyyy  yyyyyyy  yyyyy  y     y yyyyyy     yyyyyyy y     y"

     ), "SoundON"),
    
    Options(ImmutableList.of(
            " HHHHH                                    ",
            "H     H HHHHH  HHHHH H  HHHH  H    H  HHHH ",
            "H     H H    H   H   H H    H HH   H H     ",
            "H     H H    H   H   H H    H H H  H  HHHH ",
            "H     H HHHHH    H   H H    H H  H H      H",
            "H     H H        H   H H    H H   HH H    H",
            " HHHHH  H        H   H  HHHH  H    H  HHHH "
       
     ), ImmutableList.of(
            " yyyyy                                    ",
            "y     y yyyyy  yyyyy y  yyyy  y    y  yyyy ",
            "y     y y    y   y   y y    y yy   y y     ",
            "y     y y    y   y   y y    y y y  y  yyyy ",
            "y     y yyyyy    y   y y    y y  y y      y",
            "y     y y        y   y y    y y   yy y    y",
            " yyyyy  y        y   y  yyyy  y    y  yyyy "
     ), "OptionText"),

    ReducedStarComponent(ImmutableList.of(
            "   H   ",
            "  H*H  ",
            "HHH*HHH",
            "Hyyyy*H",
            " HyyyH ",
            "Hy*Hy*H",
            "HHH HHH"
    ), ImmutableList.of(""), "StarReduced"),

    ReducedSpeedComponent(ImmutableList.of(
            "     HH",
            "  HHHGH",
            "  HRHNH",
            "  HRHH ",
            "HHHRH  ",
            "H**RH  ",
            "HHHHH  "
    ), ImmutableList.of(""), "StarReduced");

    private final ImmutableList<String> image;
    private final ImmutableList<String> imageSelected;
    private final String name;
    private static final List<Components> numbers = Arrays.asList(Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine);
    private static final List<Components> ordinalNumbers = Arrays.asList(First, Second, Third, Fourth, Fifth);
    Components(ImmutableList<String> image, ImmutableList<String> imageSelected, String name) {
        this.image = image;
        this.imageSelected = imageSelected;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ImmutableList<String> getImage() {
        return image;
    }

    public ImmutableList<String> getImageSelected() {
        return imageSelected;
    }

    public ImmutableList<String> getImage(String name) {
        for (Components c : Components.values()) {
            if (c.getName().equals(name)) {
                return c.getImage();
            }
        }
        return ImmutableList.of("não funcionou");
    }


    public static List<Components> getNumbers() {
        return numbers;
    }

    public static List<Components> getOrdinalNumbers() {
        return ordinalNumbers;
    }
}
