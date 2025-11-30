        // Ejercicio 1: Ver contraseña
        document.addEventListener('DOMContentLoaded', function() {
            let passwordInput = document.getElementById('password-input');
            let toggleButton = document.getElementById('toggle-password');
            
            toggleButton.addEventListener('click', function() {
                if (passwordInput.type === 'password') {
                    passwordInput.type = 'text';
                    toggleButton.textContent = 'Ocultar';
                } else {
                    passwordInput.type = 'password';
                    toggleButton.textContent = 'Ver';
                }
            });
            
            // Ejercicio 2: Tres en raya
            let gameBoard = document.getElementById('game-board');
            let startButton = document.getElementById('start-game');
            let resetButton = document.getElementById('reset-game');
            let player1Input = document.getElementById('player1');
            let player2Input = document.getElementById('player2');
            
            let currentPlayer = 1;
            let gameActive = false;
            let boardState = ['', '', '', '', '', '', '', '', ''];
            

            for (let i = 0; i < 9; i++) {
                let cell = document.createElement('div');
                cell.className = 'cell disabled';
                cell.dataset.index = i;
                cell.addEventListener('click', handleCellClick);
                gameBoard.appendChild(cell);
            }
            
            
            startButton.addEventListener('click', function() {
                if (player1Input.value.trim() === '' || player2Input.value.trim() === '') {
                    alert('Por favor, introduce los nombres de ambos jugadores');
                    return;
                }
                
                gameActive = true;
                let cells = document.querySelectorAll('.cell');
                cells.forEach(cell => {
                    cell.classList.remove('disabled');
                    cell.textContent = '';
                });
                
                boardState = ['', '', '', '', '', '', '', '', ''];
                currentPlayer = 1;
            });
            
            
            resetButton.addEventListener('click', function() {
                gameActive = false;
                let cells = document.querySelectorAll('.cell');
                cells.forEach(cell => {
                    cell.classList.add('disabled');
                    cell.textContent = '';
                    cell.classList.remove('player1', 'player2');
                });
                
                boardState = ['', '', '', '', '', '', '', '', ''];
                currentPlayer = 1;
            });
            
           
            function handleCellClick(event) {
                if (!gameActive) return;
                
                let cell = event.target;
                let index = parseInt(cell.dataset.index);
                
                if (boardState[index] !== '') return;
                
                boardState[index] = currentPlayer;
                cell.textContent = currentPlayer === 1 ? 'X' : 'O';
                cell.classList.add(currentPlayer === 1 ? 'player1' : 'player2');
                
                if (checkWinner()) {
                    let winnerName = currentPlayer === 1 ? player1Input.value : player2Input.value;
                    alert(`¡Felicidades! ${winnerName} ha ganado la partida.`);
                    gameActive = false;
                    return;
                }
                
                if (boardState.every(cell => cell !== '')) {
                    alert('¡Empate!');
                    gameActive = false;
                    return;
                }
                
                currentPlayer = currentPlayer === 1 ? 2 : 1;
            }
            
            
            function checkWinner() {
                let winPatterns = [
                    [0, 1, 2], [3, 4, 5], [6, 7, 8], // Filas
                    [0, 3, 6], [1, 4, 7], [2, 5, 8], // Columnas
                    [0, 4, 8], [2, 4, 6]             // Diagonales
                ];
                
                return winPatterns.some(pattern => {
                    return pattern.every(index => {
                        return boardState[index] === currentPlayer;
                    });
                });
            }
            
            
            let colorPicker = document.getElementById('color-picker');
            let selectedColorBox = document.getElementById('selected-color');
            let appliedColorBox = document.getElementById('applied-color');
            let applyColorButton = document.getElementById('apply-color');
            let colorGrid = document.getElementById('color-grid');
            
            let currentColor = colorPicker.value;
            
            // Actualizar color seleccionado
            colorPicker.addEventListener('input', function() {
                currentColor = colorPicker.value;
                selectedColorBox.style.backgroundColor = currentColor;
            });
            
            // Aplicar color
            applyColorButton.addEventListener('click', function() {
                appliedColorBox.style.backgroundColor = currentColor;
            });
            
            // Crear cuadrícula
            for (let i = 0; i < 100; i++) {
                let gridCell = document.createElement('div');
                gridCell.className = 'grid-cell';
                gridCell.addEventListener('mouseover', function() {
                    if (event.buttons === 1) {
                        this.style.backgroundColor = currentColor;
                    }
                });
                gridCell.addEventListener('mousedown', function() {
                    this.style.backgroundColor = currentColor;
                });
                colorGrid.appendChild(gridCell);
            }
            
            
            colorGrid.addEventListener('mousedown', function() {
                colorGrid.isPainting = true;
            });
            
            document.addEventListener('mouseup', function() {
                colorGrid.isPainting = false;
            });
            
            colorGrid.addEventListener('mouseover', function(event) {
                if (colorGrid.isPainting && event.target.classList.contains('grid-cell')) {
                    event.target.style.backgroundColor = currentColor;
                }
            });
        });