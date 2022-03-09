#!/usr/bin/python3
class BankAccount:

    def __init__(self, members_given_name: str):
        """
        Constructs a new account for the person with the given name,\n
        with $0.00 balance
        """
        self._name = members_given_name
        self._balance = float(0.00)

    @property
    def name(self) -> str:
        """
        Returns the account name as a string
        """
        return self._name

    @property
    def balance(self) -> float:
        """
        Returns the account balance as a real number
        """
        return self._balance

    def deposit(self, amount: float):
        """
        Adds the given amount of money, as a real number,\n
        to the account balance; if the amount is negative, does nothing
        """
        if amount > 0:
            self._balance += amount

    def withdraw(self, amount: float):
        """
        subtracts the given amount of money, as a real number,
        from the account balance; if the amount is negative or
        exceeds the account's balance, does nothing
        """

        if amount >= 0 and amount <= self._balance:
            self._balance -= amount
