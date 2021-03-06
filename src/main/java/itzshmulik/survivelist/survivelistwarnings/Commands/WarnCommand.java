/*
 * MIT License
 *
 * Copyright (c) 2021 shmulik55 <https://github.com/shmulik55>
 * Copyright (c) 2021 Matt (ms5984) <https://github.com/ms5984>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package itzshmulik.survivelist.survivelistwarnings.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/**
 * Implements the main plugin command.
 *
 * @since 1.0.0
 */
public class WarnCommand implements CommandExecutor {

    private final JavaPlugin plugin = JavaPlugin.getProvidingPlugin(getClass());

    String offlinePlayerMsg = plugin.getConfig().getString("Offline-target-message");

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {


        Player player = (Player) sender;
        // Enables the /warn command, works only if the target is online.
        if(player.hasPermission("warnings.warn") || player.hasPermission("warnings.staff")) {
            if (args.length > 0) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target instanceof Player) {

                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', offlinePlayerMsg));
                }
            }
        }
        return false;
    }
}
