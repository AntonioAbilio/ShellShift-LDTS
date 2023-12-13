package com.l06g06.shellshift.controller.game;

import com.l06g06.shellshift.Sound;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.map.Map;

import java.util.Iterator;
import java.util.List;


public abstract class GameController extends Controller<Map> {
    public GameController(Map map) {
        super(map);
    }
    /*
    protected boolean ElementEnemyCollision(Element element){
        boolean isColliding = false;
        List<Enemy> enemies = getModel().getEnemies();
        Iterator<Enemy> enemiesIterator = enemies.iterator();

        while (enemiesIterator.hasNext()) {
            Enemy enemy = enemiesIterator.next();
            if (element.getPolygon().intersects(enemy.getPolygon().getBounds2D())) {
                Sound.playSound(Sound.SoundsFx.MonsterCollision);

                enemiesIterator.remove();
                isColliding = true;
            }
        }
        return isColliding;
    }



    protected void elementInsidePlatform(Element element){
        for (Platform platform : getModel().getPlatforms()) {
            if (element.getPolygon().intersects(platform.getPolygon().getBounds2D())) {
                int elementPositionY = element.getPosition().getY();
                if (elementPositionY > platform.getPolygon().getBounds2D().getMinY() && elementPositionY < platform.getPolygon().getBounds2D().getMaxY()){
                    element.setPosition(new Position(element.getPosition().getX(),(int) platform.getPolygon().getBounds2D().getMinY()+7));
                }
            }
            break;
        }
    }
    */
}
