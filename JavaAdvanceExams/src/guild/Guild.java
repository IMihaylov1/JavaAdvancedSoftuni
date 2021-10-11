package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {

    private String name;
    private int capacity;
    private List<Player> playerList;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.playerList = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (capacity > playerList.size())
            this.playerList.add(player);
    }

    public boolean removePlayer(String name) {
        for (Player player : playerList) {
            String playerName = player.getName();
            if (playerName.equals(name)) {
                playerList.remove(player);
                return true;
            }
        }
        return false;
    }

    public int count() {
        return playerList.size();
    }

    public void promotePlayer(String name) {
        for (Player player : playerList) {
            String playerName = player.getName();
            if (playerName.equals(name)) {
                String rank = player.getRank();
                if (!rank.equals("Member")) {
                    player.setRank("Member");
                    break;
                }
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : playerList) {
            String playerName = player.getName();
            if (playerName.equals(name)) {
                String rank = player.getRank();
                if (!rank.equals("Trial")) {
                    player.setRank("Trial");
                    break;
                }
            }
        }

    }

    public String getName() {
        return this.name;
    }

    public Player[] kickPlayersByClass(String clazz) {

        List<Player> kickedPlayers = new ArrayList<>();
        int size = 0;
        int count = 0;
        for (Player player : playerList) {
            String playerClazz = player.getClazz();
            if (playerClazz.equals(clazz)) {
                kickedPlayers.add(player);
                size++;
            }
        }
        Player[] kickPlayers = new Player[size];
        for (Player kickedPlayer : kickedPlayers) {
            kickPlayers[count] = kickedPlayer;
            count++;
        }
        for (Player kickedPlayer : kickedPlayers) {
            while (playerList.contains(kickedPlayer)){
                playerList.remove(kickedPlayer);
            }
        }

        return kickPlayers;
    }

    public String report() {
        String first = String.format("Players in the guild: %s:", getName());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(first);
        stringBuilder.append(System.lineSeparator());
        for (Player player : playerList) {
            stringBuilder.append(player.toString());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
