package main;

import entity.Entity;

public class CollisionChecker 
{
	GamePanel gp;
	 public CollisionChecker(GamePanel gp)
	{
		this.gp=gp;
	}
	
	public void checkTile(Entity entity) 
	{
		int entityLworldx= entity.worldx+entity.solidArea.x;
		int entityRworldx= entity.worldx+entity.solidArea.x + entity.solidArea.width;
		int entityTworldy= entity.worldy+entity.solidArea.y;
		int entityBworldy= entity.worldy+entity.solidArea.y+ entity.solidArea.height;
		
		int entityLcol= entityLworldx/gp.tileSize;
		int entityRcol= entityRworldx/gp.tileSize;
		int entityTrow=entityTworldy/gp.tileSize;
		int entityBrow=entityBworldy/gp.tileSize;
		
		int tilen1, tilen2;
		switch (entity.direction) {
		case "up": 
			entityTrow=(entityTworldy-entity.speed)/gp.tileSize;
			tilen1 = gp.tileManager.mapTileNum[entityLcol][entityTrow];
			tilen2 = gp.tileManager.mapTileNum[entityRcol][entityTrow];
			if(gp.tileManager.tile[tilen1].collision==true || gp.tileManager.tile[tilen2].collision==true ) 
			{
				entity.collisionOn=true;
			}
		break;
		case "down": 
			entityBrow=(entityBworldy+entity.speed)/gp.tileSize;
			
			tilen1 = gp.tileManager.mapTileNum[entityLcol][entityBrow];
			tilen2 = gp.tileManager.mapTileNum[entityRcol][entityBrow];
			if(gp.tileManager.tile[tilen1].collision==true || gp.tileManager.tile[tilen2].collision==true ) 
			{
				entity.collisionOn=true;
			}
			
		break;
		case "left": 
			entityLcol=(entityLworldx-entity.speed)/gp.tileSize;
			
			tilen1 = gp.tileManager.mapTileNum[entityLcol][entityTrow];
			tilen2 = gp.tileManager.mapTileNum[entityRcol][entityBrow];
			if(gp.tileManager.tile[tilen1].collision==true || gp.tileManager.tile[tilen2].collision==true ) 
			{
				entity.collisionOn=true;
			}
			
		break;
		case "right": 
			entityRcol=(entityRworldx+entity.speed)/gp.tileSize;
			
			tilen1 = gp.tileManager.mapTileNum[entityLcol][entityTrow];
			tilen2 = gp.tileManager.mapTileNum[entityRcol][entityBrow];
			if(gp.tileManager.tile[tilen1].collision==true || gp.tileManager.tile[tilen2].collision==true ) 
			{
				entity.collisionOn=true;
			}
			
		break;
		
		}
	}
}