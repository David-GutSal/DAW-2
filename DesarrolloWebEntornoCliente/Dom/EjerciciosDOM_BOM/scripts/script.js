function verPassword() {
  let pw = document.getElementsByTagName("input")[0];
  if (pw.getAttribute("type") == "password") {
    pw.setAttribute("type", "text");
  } else {
    pw.setAttribute("type", "password");
  }
}

var player1 = Array(9).fill(0);
var player2 = Array(9).fill(0);
var positionReserved = Array(9).fill(0);
let round = 0;
var win1 = [1, 1, 1, 0, 0, 0, 0, 0, 0];
var win2 = [0, 0, 0, 1, 1, 1, 0, 0, 0];
var win3 = [0, 0, 0, 0, 0, 0, 1, 1, 1];
var win4 = [1, 0, 0, 1, 0, 0, 1, 0, 0];
var win5 = [0, 1, 0, 0, 1, 0, 0, 1, 0];
var win6 = [0, 0, 1, 0, 0, 1, 0, 0, 1];
var win7 = [1, 0, 0, 0, 1, 0, 0, 0, 1];
var win8 = [0, 0, 1, 0, 1, 0, 1, 0, 0];

function startCruz() {
  let table = document.getElementsByTagName("table")[0];
  table.setAttribute("class", "startGame");
  let boxPosition = Array.from(document.getElementsByTagName("td"));
  boxPosition.forEach((box, i) => {
    let td = document.getElementsByTagName("td")[i];
    td.setAttribute("onclick", `presButton(${i})`);
  });
}

function presButton(position) {
  let bottonPressed = position;
  let player;

  if (round % 2 == 0) {
    player = 1;
  } else {
    player = 2;
  }

  if (positionReserved[bottonPressed] == 0) {
    positionReserved[bottonPressed] = 1;
    switch (bottonPressed) {
      case 0:
        if (player == 1) {
          player1[bottonPressed] = 1;
          checkStade(player1, player);
        } else if (player == 2) {
          player2[bottonPressed] = 1;
          checkStade(player2, player);
        }
        break;
      case 1:
        if (player == 1) {
          player1[bottonPressed] = 1;
          checkStade(player1, player);
        } else if (player == 2) {
          player2[bottonPressed] = 1;
          checkStade(player2, player);
        }
        break;
      case 2:
        if (player == 1) {
          player1[bottonPressed] = 1;
          checkStade(player1, player);
        } else if (player == 2) {
          player2[bottonPressed] = 1;
          checkStade(player2, player);
        }
        break;
      case 3:
        if (player == 1) {
          player1[bottonPressed] = 1;
          checkStade(player1, player);
        } else if (player == 2) {
          player2[bottonPressed] = 1;
          checkStade(player2, player);
        }
        break;
      case 4:
        if (player == 1) {
          player1[bottonPressed] = 1;
          checkStade(player1, player);
        } else if (player == 2) {
          player2[bottonPressed] = 1;
          checkStade(player2, player);
        }
        break;
      case 5:
        if (player == 1) {
          player1[bottonPressed] = 1;
          checkStade(player1, player);
        } else if (player == 2) {
          player2[bottonPressed] = 1;
          checkStade(player2, player);
        }
        break;
      case 6:
        if (player == 1) {
          player1[bottonPressed] = 1;
          checkStade(player1, player);
        } else if (player == 2) {
          player2[bottonPressed] = 1;
          checkStade(player2, player);
        }
        break;
      case 7:
        if (player == 1) {
          player1[bottonPressed] = 1;
          checkStade(player1, player);
        } else if (player == 2) {
          player2[bottonPressed] = 1;
          checkStade(player2, player);
        }
        break;
      case 8:
        if (player == 1) {
          player1[bottonPressed] = 1;

          checkStade(player1, player);
        } else if (player == 2) {
          player2[bottonPressed] = 1;
          checkStade(player2, player);
        }
        break;
    }
  }
  round++;
}

function checkStade(playerPlays, player) {
  let winCond = [win1, win2, win3, win4, win5, win6, win7, win8];
  for (let win of winCond) {
    if (arraysEqual(win, playerPlays)) {
      let boxPosition = Array.from(document.getElementsByTagName("td"));
      boxPosition.forEach((box, i) => {
        box.removeAttribute("onclick");
      });

      let table = document.getElementsByTagName("table")[0];
      let playerName =
        document.getElementsByTagName("input")[player].value ||
        `Player ${player}`;
      let winer = document.createElement("p");
      winer.innerText = `Ha ganado el jugador ${playerName}`;
      table.after(winer);
      return;
    }
  }
}

function arraysEqual(a, b) {
  if (a.length !== b.length) return false;
  for (let i = 0; i < a.length; i++) {
    if (a[i] !== b[i]) return false;
  }
  return true;
}
