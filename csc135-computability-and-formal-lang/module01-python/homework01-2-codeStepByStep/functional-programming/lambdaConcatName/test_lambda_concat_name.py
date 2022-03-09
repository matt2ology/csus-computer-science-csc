import lambda_concat_name_solution as soln

assert soln.f("Cynthia", "Lee") == "Lee, Cynthia"
assert soln.f("john", "doe") == "doe, john"
assert soln.f("Andrew Dice", "Clay") == "Clay, Andrew Dice"
assert soln.f("A", "B") == "B, A"
