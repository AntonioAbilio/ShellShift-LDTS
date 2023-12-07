package com.l06g06.shellshift;

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
    }, new String[]{}, "Icon"),

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
    }, "Main Menu");
    

    private final String[] image;
    private final String[] imageSelected;
    private final String name;
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
}
