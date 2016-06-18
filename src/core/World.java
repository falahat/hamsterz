package core;

import actor.Actor;
import location.Grid;
import location.GridLocation2D;

import java.util.*;

/**
 * Created by aryan on 6/17/2016.
 */
public class World {

    private Grid<GridLocation2D> grid;
    private List<Actor> allMembers;
    private List<Actor> actors; // Just those we expect moves from

    public World(Grid grid) {
        this.grid = grid;
        this.allMembers = new ArrayList<Actor>();
        this.actors = new ArrayList<Actor>();
    }

    public void addMember(Actor actor, GridLocation2D to, boolean canMove) {
        allMembers.add(actor);
        if (canMove) {
            actors.add(actor);
        }
        grid.addMember(actor, to);
    }

    public void turn() {
        for (Actor actor : this.actors) {
            actor.act();
        }
    }

    public Map<Actor, GridLocation2D> getDisplayInfoByMember() {
        Map<Actor, GridLocation2D> ans = new TreeMap<Actor, GridLocation2D>();
        for (Actor member : allMembers) {
            GridLocation2D loc = grid.locationOf(member);
            ans.put(member, loc);
        }
        return ans;
    }

    public Map<GridLocation2D, Actor> getDisplayInfoByLocation() {
        Map<GridLocation2D, Actor> ans = new HashMap<GridLocation2D, Actor>();
        for (Actor member : allMembers) {
            GridLocation2D loc = grid.locationOf(member);
            ans.put(loc, member);
        }
        return ans;
    }

}