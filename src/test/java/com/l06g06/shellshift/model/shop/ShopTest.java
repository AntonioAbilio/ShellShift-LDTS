package com.l06g06.shellshift.model.shop;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShopTest {

    private Shop shop;

    @BeforeEach
    public void setUp(){
        Database.getInstance().setSound(true);
        shop = new Shop();
    }

    @Test
    public void isSelectedRapidFire(){
        int i = 0;
        Assertions.assertFalse(shop.getOptions().isEmpty());
        while (!shop.isSelectedRapidFire()){
            if (i >= 2) fail();
            shop.nextOption();
            i++;
        }
        if (i != 0) fail();
        assertTrue(shop.isSelected(i));
        assertTrue(shop.isSelectedRapidFire());
        assertFalse(shop.isSelectedExtraLife());
        assertFalse(shop.isSelectedMoreBullets());

        while (!shop.isSelectedMoreBullets()){
            if (i >= 2) fail();
            shop.nextOption();
            i++;
        }

        assertTrue(shop.isSelected(i));
        assertTrue(shop.isSelectedMoreBullets());
        if (i != 2) fail();
    }

    @Test
    public void isSelectedExtraLife(){
        int i = 0;
        Assertions.assertFalse(shop.getOptions().isEmpty());
        while (!shop.isSelectedExtraLife()){
            if (i >= 2) fail();
            shop.nextOption();
            i++;
        }
        if (i != 1) fail();
        assertTrue(shop.isSelected(i));
        assertTrue(shop.isSelectedExtraLife());
        assertFalse(shop.isSelectedMoreBullets());
        assertFalse(shop.isSelectedRapidFire());

        while (!shop.isSelectedMoreBullets()){
            if (i >= 2) fail();
            shop.nextOption();
            i++;
        }
        assertTrue(shop.isSelected(i));
        assertTrue(shop.isSelectedMoreBullets());
        if (i != 2) fail();
    }

    @Test
    public void isSelectedMoreBullets(){
        int i = 0;
        Assertions.assertFalse(shop.getOptions().isEmpty());

        while (!shop.isSelectedMoreBullets()){
            if (i >= 2) fail();
            shop.nextOption();
            i++;
        }
        assertTrue(shop.isSelected(i));
        assertTrue(shop.isSelectedMoreBullets());
        assertFalse(shop.isSelectedExtraLife());
        assertFalse(shop.isSelectedRapidFire());
        if (i != 2) fail();
    }

    @Test
    public void testComponentsAndOptions(){
        List<Components> expectedComponents = Arrays.asList(Components.RapidFireIcon ,Components.HeartIcon, Components.MoreBulletsIcon);

        assertEquals(shop.getIcons(), expectedComponents);
        assertEquals(50, shop.getPrice(Components.RapidFire));
        assertEquals(20, shop.getPrice(Components.ExtraLife));
        assertEquals(10, shop.getPrice(Components.MoreBullets));

        int i = 0;
        while (!shop.isSelectedMoreBullets()){
            if (i >= 2) fail();
            shop.nextOption();
            i++;
        }
        assertTrue(shop.isSelected(i));
        assertTrue(shop.isSelectedMoreBullets());
        assertFalse(shop.isSelectedExtraLife());
        assertFalse(shop.isSelectedRapidFire());
        if (i != 2) fail();
    }

    @Test
    public void nextOptionTest() {
        shop.nextOption();
        assertTrue( shop.isSelected(1));
    }

    @Test
    public void prevOptionTest() {
        shop.prevOption();
        assertTrue(shop.isSelected(0));
    }

    @Test
    public void testForOverflow(){
        int i = 0;
        while (!shop.isSelectedMoreBullets()){
            if (i >= 2) fail();
            shop.nextOption();
            i++;
        }
        shop.nextOption();
        if (!shop.isSelected(2)) fail();
        if (i != 2) fail();
    }

}
