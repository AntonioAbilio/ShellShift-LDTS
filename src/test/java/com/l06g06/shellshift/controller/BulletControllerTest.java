package com.l06g06.shellshift.controller;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.controller.game.elements.BulletController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Bullet;
import com.l06g06.shellshift.model.game.elements.Chell;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.MoveStrategy;
import com.l06g06.shellshift.model.game.gun.FireStrategy;
import com.l06g06.shellshift.model.game.gun.Gun;
import com.l06g06.shellshift.model.game.gun.NormalFireStrategy;
import com.l06g06.shellshift.model.game.map.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class BulletControllerTest {
        private Map map ;
        private Bullet bullet;
        private Gun gun;
        private FireStrategy fireStrategy;
        private List<Bullet> bullets;
        private BulletController bulletController;
        private Game game;


        @BeforeEach
        public void setup(){
            this.map = mock(Map.class);
            this.bullet = mock(Bullet.class);
            this.bullets = new ArrayList<>();
            this.fireStrategy = mock(FireStrategy.class);
            this.gun = new Gun(fireStrategy);
            this.game = mock(Game.class);
            Mockito.when(map.getBullets()).thenReturn(bullets);
            Mockito.when(map.getGun()).thenReturn(gun);
            this.bulletController = new BulletController(map);

            Bullet bullet1 = new Bullet(new Position(1,  0));
            Bullet bullet2 = new Bullet(new Position(5, 5));
            Bullet bullet3 = new Bullet(new Position(2, 9));
            bullet1.setDirection(true); // right
            bullet2.setDirection(false); // left
            bullet3.setDirection(true); // right
            bullets.add(bullet1);
            bullets.add(bullet2);
            bullets.add(bullet3);
            gun = new Gun(new NormalFireStrategy());
        }

        @Test
        public void bulletUpdateTest(){
            bulletController.bulletUpdate();
            Assertions.assertEquals(new Position(3, 0), bullets.get(0).getPosition());
            Assertions.assertEquals(new Position(3, 5), bullets.get(1).getPosition());
            Assertions.assertEquals(new Position(4, 9), bullets.get(2).getPosition());
        }

        @Test
        public void bulletCollisionTest(){
            List<Enemy> enemies = new ArrayList<>();
            MoveStrategy mockedMoveStrategy = mock(MoveStrategy.class);
            Mockito.when(map.getEnemies()).thenReturn(enemies);
            Enemy enemy1 = new SoftMonster(new Position(-12,  -13), mockedMoveStrategy);
            Enemy enemy2 = new HardMonster(new Position(16, 5), mockedMoveStrategy);
            Enemy enemy3 = new HardMonster(new Position(32, 9), mockedMoveStrategy);
            enemies.add(enemy1);
            enemies.add(enemy2);
            enemies.add(enemy3);

            Assertions.assertEquals(3, enemies.size());
            bulletController.bulletCollision();
            Assertions.assertEquals(2, enemies.size());

            // ToDo: remove
            /*int test_x_inf = -20;
            int test_x_sup = 20;
            int test_y_inf = -30;
            int test_y_sup = 30;
            boolean intersectionFound = false;

            for (int i = test_x_inf; i <= test_x_sup && !intersectionFound; i++) {
                for (int j = test_y_inf; j <= test_y_sup && !intersectionFound; j++) {
                    enemy1.setPosition(new Position(i, j));

                    // Check for intersection
                    if (enemy1.getPolygon().intersects(bullets.get(0).getPolygon().getBounds2D())) {
                        System.out.println("Intersection found at x: " + i + " y: " + j);
                        intersectionFound = true;
                    }
                }
            }*/
        }

        @Test
        public void stepTest(){
            this.fireStrategy = new NormalFireStrategy();
            this.gun = new Gun(fireStrategy);
            gun.setNumBullets(4);
            double reloadTime = gun.getReloadTime();
            long fireTime = (long) (200 + reloadTime);
            when(map.getChell()).thenReturn(mock(Chell.class));
            when(map.getChell().isDirection()).thenReturn(true);
            when(map.getChell().getPosition()).thenReturn(mock(Position.class));

            Assertions.assertEquals(30, map.getGun().getNumBullets());

            List<Gui.PressedKey> actions = Arrays.asList(Gui.PressedKey.FIRE);

            bulletController.step(game, actions, fireTime);

            //Assertions.assertEquals(3, map.getGun().getNumBullets());
        }


}

