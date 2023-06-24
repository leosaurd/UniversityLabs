# Minmax algorithm searches for the the best path through using 1's and 0's, of which
# the 'game-tree' will be recursively searched through to find the optimal path(assuming both player & opponent
# play optimally).

# Pseudo-code:
# function Minmax (node, depth, maxPlayer) is
# if depth == 0 || node == tnode then
# return static eval:node

# if maxPlayer then
# maxEva = -inf
# for each child of node, do
# eva = minmax(child, depth-1, false)
# maxEva = max(maxEva, eva)
# return maxEva

# else
# minEva = +inf
# for each child of node, do
# eva = minmax(child, depth-1, true)
# minEva = min(minEva, eva)
# return minEva
