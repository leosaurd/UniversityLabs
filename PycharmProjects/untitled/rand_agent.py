# Import the tic tac toe class
from tictactoe import tictactoe
# Import the random number generation library
import random


# Create a subclass of tic tac toe with an implementation of
# the agent_move function
class MyGame(tictactoe):

    # The agent_move function - the function has to tell the
    # tic tac toe class what move to make next in the game
    #
    # Inputs: state - current state of the board
    # Returns: new state of the board with the proposed move
    def agent_move(self, state):
        best_result = -100
        best_state = state
        new_states = self.max_possible_moves(state)
        for s in new_states:
            result = self.min_move(s, 8)
            if result > best_result:
                best_result = result
                best_state = s
        return best_state

    def min_move(self, state, depth):
        score = 100
        if self.terminal(state) or depth == 0:
            return self.evaluate(state)
        next_state = self.min_possible_moves(state)
        for s in next_state:
            results = self.max_move(s, depth-1)
            if results < score:
                score = results
        return score

    def max_move(self, state, depth):
        score = -100
        if self.terminal(state) or depth == 0:
            return self.evaluate(state)
        next_state = self.max_possible_moves(state)
        for s in next_state:
            results = self.max_move(s, depth-1)
            if results > score:
                score = results
        return score


while True:
    # Run a game where the human makes the first move
    MyGame(opponent="x")
    # Run a game where the agents makes the first move
    MyGame(opponent="o")