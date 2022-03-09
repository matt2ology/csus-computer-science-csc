#!/usr/bin/python3
from bank_account import BankAccount


def test_constructor_case01():
    ba = BankAccount("Eve")
    assert ba.name == "Eve"
    assert ba.balance == 0.0


def test_deposit01_case02():
    ba = BankAccount("Eve")
    ba.deposit(5.0)
    assert ba.balance == 5.0


def test_deposit02_multiple_case03():
    ba = BankAccount("Eve")
    ba.deposit(35)
    ba.deposit(.5)
    assert ba.balance == 35.5


def test_deposit03_invalid_case04():
    ba = BankAccount("Eve")
    ba.deposit(5)
    ba.deposit(-12.0)
    assert ba.balance == 5.0


def test_withdraw01_case05():
    ba = BankAccount("Eve")
    ba.deposit(20)
    ba.withdraw(8)
    assert ba.balance == 12.0


def test_withdraw02_multiple_case06():
    ba = BankAccount("Eve")
    ba.deposit(45)
    ba.withdraw(4)
    ba.withdraw(.5)
    assert ba.balance == 40.5

def test_withdraw03_invalid_case07():
    ba = BankAccount("Eve")
    ba.deposit(100)
    ba.withdraw(500)
    assert ba.balance == 100
