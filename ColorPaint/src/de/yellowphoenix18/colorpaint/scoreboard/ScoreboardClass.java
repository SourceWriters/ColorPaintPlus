package de.yellowphoenix18.colorpaint.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import de.yellowphoenix18.colorpaint.ColorPaint;
import de.yellowphoenix18.colorpaint.config.MessagesConfig;

public class ScoreboardClass {
	
	public static Player first = null;
	public static int first_i = -1;
	public static Player second = null;
	public static int second_i = -1;
	public static Player third = null;
	public static int third_i = -1;
	public static Player fourth = null;
	public static int fourth_i = -1;
	public static Player fifth = null;
	public static int fifth_i = -1;
	
	public static void getBests() {	
		first = null;
		second = null;
		third = null;
		fourth = null;
		fifth = null;
		first_i = -1;
		second_i = -1;
		third_i = -1;
		fourth_i = -1;
		fifth_i = -1;
		for(Player all : ColorPaint.painters) {
			if(ColorPaint.kills.get(all) >= first_i) {
				fifth = fourth;
				fifth_i = fourth_i;
				fourth = third;
				fourth_i = third_i;
				third = second;
				third_i = second_i;
				second = first;
				second_i = first_i;
				first = all;
				first_i = ColorPaint.kills.get(all);
			} else if(ColorPaint.kills.get(all) >= second_i) {
				fifth = fourth;
				fifth_i = fourth_i;
				fourth = third;
				fourth_i = third_i;
				third = second;
				third_i = second_i;
				second = all;
				second_i = ColorPaint.kills.get(all);
			} else if(ColorPaint.kills.get(all) >= third_i) {
				fifth = fourth;
				fifth_i = fourth_i;
				fourth = third;
				fourth_i = third_i;
				third = all;
				third_i = ColorPaint.kills.get(all);
			} else if(ColorPaint.kills.get(all) >= fourth_i) {
				fifth = fourth;
				fifth_i = fourth_i;
				fourth = all;
				fourth_i = ColorPaint.kills.get(all);
			} else if(ColorPaint.kills.get(all) >= fifth_i) {
				fifth = all;
				fifth_i = ColorPaint.kills.get(all);
			}
		}
	}
	
	public static void updateScoreboard(Player p) {
		Scoreboard b = Bukkit.getScoreboardManager().getNewScoreboard();
		if (b.getObjective("Lobby") == null) {
			Objective obj = b.registerNewObjective("Lobby", "dummy");
			
			obj.setDisplayName(MessagesConfig.scoreboard);
			if(first != null) {
				obj.getScore(first.getName()).setScore(ColorPaint.kills.get(first));	
			}
			if(second != null) {
				obj.getScore(second.getName()).setScore(ColorPaint.kills.get(second));	
			}
			if(third != null) {
				obj.getScore(third.getName()).setScore(ColorPaint.kills.get(third));	
			}
			if(fourth != null) {
				obj.getScore(fourth.getName()).setScore(ColorPaint.kills.get(fourth));	
			}
			if(fifth != null) {
				obj.getScore(fifth.getName()).setScore(ColorPaint.kills.get(fifth));	
			}
			obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		} else {
			Objective obj = b.getObjective("Lobby");
			
			if(first != null) {
				obj.getScore(first.getName()).setScore(ColorPaint.kills.get(first));	
			}
			if(second != null) {
				obj.getScore(second.getName()).setScore(ColorPaint.kills.get(second));	
			}
			if(third != null) {
				obj.getScore(third.getName()).setScore(ColorPaint.kills.get(third));	
			}
			if(fourth != null) {
				obj.getScore(fourth.getName()).setScore(ColorPaint.kills.get(fourth));	
			}
			if(fifth != null) {
				obj.getScore(fifth.getName()).setScore(ColorPaint.kills.get(fifth));	
			}
			
		}
		p.setScoreboard(b);
	}

}
