package me.abandoncaptian.TNTWars;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuHandler implements Listener{
	Inventory inv;
	Main pl;
	public MenuHandler(Main plugin) {
		pl = plugin;
		inv = Bukkit.createInventory(null, 45, "�c�lTNT Wars Menu");
		ItemMeta meta;
		List<String> lore = new ArrayList<String>();
		ItemStack join = new ItemStack(Material.WOOL, 1, (short)13);
		meta = join.getItemMeta();
		meta.setDisplayName("�aJoin TNT Wars");
		lore.add("�6�l---- �c[ TNT Wars ] �6�l----");
		lore.add("�bClick to join TNT Wars");
		meta.setLore(lore);
		lore.clear();
		join.setItemMeta(meta);
		ItemStack leave = new ItemStack(Material.WOOL, 1, (short)14);
		meta = leave.getItemMeta();
		meta.setDisplayName("�aLeave TNT Wars");
		lore.add("�6�l---- �c[ TNT Wars ] �6�l----");
		lore.add("�bClick to leave TNT Wars");
		meta.setLore(lore);
		lore.clear();
		leave.setItemMeta(meta);
		ItemStack kits = new ItemStack(Material.CHEST);
		meta = kits.getItemMeta();
		meta.setDisplayName("�aTNT Wars Kits");
		lore.add("�6�l---- �c[ TNT Wars ] �6�l----");
		lore.add("�bClick to see TNT Wars kits");
		meta.setLore(lore);
		lore.clear();
		kits.setItemMeta(meta);
		ItemStack close = new ItemStack(Material.ARROW);
		meta = close.getItemMeta();
		meta.setDisplayName("�aClose TNT Wars Menu");
		lore.add("�6�l---- �c[ TNT Wars ] �6�l----");
		lore.add("�bClick to close TNT Wars Menu");
		meta.setLore(lore);
		lore.clear();
		close.setItemMeta(meta);
		inv.setItem(10, join);
		inv.setItem(13, kits);
		inv.setItem(16, leave);
		inv.setItem(31, close);
	}

	@EventHandler
	public void invClick(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getClickedInventory().getSize() == inv.getSize()){
			if(e.getClickedInventory().getTitle().equals("�c�lTNT Wars Menu")){
				e.setCancelled(true);
				ItemStack clicked = e.getCurrentItem();
				if(clicked == null)return;
				String itemName = clicked.getItemMeta().getDisplayName();
				switch(itemName){
				case "�aJoin TNT Wars": 
					p.performCommand("tw j");
					p.closeInventory();
					break;
				case "�aLeave TNT Wars": 
					p.performCommand("tw l");
					p.closeInventory();
					break;
				case "�aTNT Wars Kits": 
					p.closeInventory();
					Bukkit.getScheduler().runTaskLater(pl, new Runnable(){
						@Override
						public void run() {
							p.performCommand("tw kits");
						}
					}, 1);
					break;
				case "�aClose TNT Wars Menu": 
					p.closeInventory();
					break;
				default: 
					p.sendMessage("�cERROR");
					p.closeInventory();
					break;
				}
				return;
			}
		}
	}

	public void Menu(Player p){
		p.openInventory(inv);
	}
}
