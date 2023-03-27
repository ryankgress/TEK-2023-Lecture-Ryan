let team1 = {
    teamName: "Breakout1",
    playerList: ["Ryan", "Edward", "Caitlin", "Justin"],
    total_score: 100
}

let team2 = {
    teamName: "Tigers",
    playerList: ["Ryan", "Riley", "Eric", "Jack"],
    total_score: 200
}

let team3 = {
    teamName: "Outside Spotlights",
    playerList: ["Ryan", "Kevin", "Katie", "Dana", "Ken"],
    total_score: 500
}

let teams = [team1, team2, team3];

let teamsShown = false;     // So you can only show teams once

function showTeams() {      // Check if button has been clicked yet
    if (!teamsShown) {
        teamsShown = true;
        let tableLoc = document.getElementById("teamTable");
        var tableText = "<tr><th>Team Name</th><th>Team Members</th><th>Total Points</th></tr>"

        for (let t of teams) {
            // Print out each team info in a new row of the table
            tableText += "<tr>";
            for (let o in t) {
                tableText += ("<td>" + formatTeams(t[o]) + "</td>");
            }
            tableText += "</tr>";
        }
        tableLoc.innerHTML += tableText;
    }

}

function formatTeams(playerList) {
    if(playerList instanceof Array) {
        return playerList.join(", ");
    }
    return playerList;
}
