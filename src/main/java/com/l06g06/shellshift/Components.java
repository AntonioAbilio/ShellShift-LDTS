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
    
    HeartIcon(new String[] {
        "  RRRR    RRRR ",
        " RQQQQR  R****R",
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
    }, new String[]{}, "Icon");

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
