package com.l06g06.shellshift;

import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;

import java.util.Arrays;
import java.util.List;

public enum Components {

    Title(new String[] {
            "      *******      *                 ***     ***              *******      *                  ***            ",
            "    *       ***  **                   ***     ***           *       ***  **          *      ** ***      *    ",
            "   *         **  **                    **      **          *         **  **         ***    **   ***    **    ",
            "   **        *   **                    **      **          **        *   **          *     **          **    ",
            "    ***          **                    **      **           ***          **                **        ********",
            "   ** ***        **  ***      ***      **      **          ** ***        **  ***   ***     ******   ******** ",
            "    *** ***      ** * ***    * ***     **      **           *** ***      ** * ***   ***    *****       **    ",
            "      *** ***    ***   ***  *   ***    **      **             *** ***    ***   ***   **    **          **    ",
            "        *** ***  **     ** **    ***   **      **               *** ***  **     **   **    **          **    ",
            "          ** *** **     ** ********    **      **                 ** *** **     **   **    **          **    ",
            "           ** ** **     ** *******     **      **                  ** ** **     **   **    **          **    ",
            "            * *  **     ** **          **      **                   * *  **     **   **    **          **    ",
            "  ***        *   **     ** ****    *   **      **         ***        *   **     **   **    **          **    ",
            " *  *********    **     **  *******    *** *   *** *     *  *********    **     **   *** * **           **   ",
            "*     *****       **    **   *****      ***     ***     *     *****       **    **    ***   **               ",
            "*                       *                               *                       *                            ",
            " **                    *                                 **                    *                             ",
            "                      *                                                       *                              ",
            "                     *                                                       *                               "
    }, new String[] {} ,"Title"),

    Start(new String[]{
            " *****                           ",
            "*     * *****   **   *****  *****",
            "*         *    *  *  *    *   *  ",
            " *****    *   *    * *    *   *  ",
            "      *   *   ****** *****    *  ",
            "*     *   *   *    * *   *    *  ",
            " *****    *   *    * *    *   *  "
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
            " *****                                                   ",
            "*     * *****   **   ***** *  ****  ***** *  ****   **** ",
            "*         *    *  *    *   * *        *   * *    * *     ",
            " *****    *   *    *   *   *  ****    *   * *       **** ",
            "      *   *   ******   *   *      *   *   * *           *",
            "*     *   *   *    *   *   * *    *   *   * *    * *    *",
            " *****    *   *    *   *   *  ****    *   *  ****   **** "
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
            " *****                ",
            "*     * *    * * *****",
            "*     * *    * *   *  ",
            "*     * *    * *   *  ",
            "*   * * *    * *   *  ",
            "*    *  *    * *   *  ",
            " **** *  ****  *   *  "
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
            " *****                      ",
            "*     * *    *  ****  ***** ",
            "*       *    * *    * *    *",
            " *****  ****** *    * *    *",
            "      * *    * *    * ***** ",
            "*     * *    * *    * *     ",
            " *****  *    *  ****  *     "
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
            "******                            *******                ",
            "*     *   **   *****  * *****     *       * *****  ******",
            "*     *  *  *  *    * * *    *    *       * *    * *     ",
            "******  *    * *    * * *    *    *****   * *    * ***** ",
            "*   *   ****** *****  * *    *    *       * *****  *     ",
            "*    *  *    * *      * *    *    *       * *   *  *     ",
            "*     * *    * *      * *****     *       * *    * ******",
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
        "*******                               *                      ",
        "*       *    * ***** *****    **      *       * ****** ******",
        "*        *  *    *   *    *  *  *     *       * *      *     ",
        "*****     **     *   *    * *    *    *       * *****  ***** ",
        "*         **     *   *****  ******    *       * *      *     ",
        "*        *  *    *   *   *  *    *    *       * *      *     ",
        "******* *    *   *   *    * *    *    ******* * *      ******"
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
        "      R**R     ",
        "       RR      ",
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
            "    HHHHHHGH",
            "    HQ**HGH",
            "     H*HGHNH",
            "     H*HHGH",
            "     H*HGHNH",
            "     H*HHHH",
            "    HQ***H",
            " HHHQ***RH",
            "HQQ***RRRH",
            "H****RRHRH",
            " HHHHHH HH"
    }, new String[]{}, "SpeedPowerUp"),
    Tutorial(new String[] {
            "*******                                           ",
            "   *    *    * *****  ****  *****  *   **   *     ",
            "   *    *    *   *   *    * *    * *  *  *  *     ",
            "   *    *    *   *   *    * *    * * *    * *     ",
            "   *    *    *   *   *    * *****  * ****** *     ",
            "   *    *    *   *   *    * *   *  * *    * *     ",
            "   *     ****    *    ****  *    * * *    * ******"
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
    }, "SpaceBar");
    

    private final String[] image;
    private final String[] imageSelected;
    private final String name;
    private static final List<Components> numbers = Arrays.asList(Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine);

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
            if (c.getName() == name) {
                return c.getImage();
            }
        }
        return new String[]{ "não funcionou" };
    }

    public String[] getImageSelected(String name) {
        for (Components c : Components.values()) {
            if (c.getName() == name) {
                return c.getImageSelected();
            }
        }
        return new String[]{ "não funcionou" };
    }

    public static List<Components> getNumbers() {
        return numbers;
    }
}
