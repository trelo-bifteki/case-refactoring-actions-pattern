# Case refactoring actions

## About

This is a sample code from a refactoring I did using a custom action pattern
and a demo code for my blog post

## Background

The main difference with the actual action pattern is its stateless design.
Making all actions stateless makes it closer to a strategy pattern and
disqualifies it for "transactional" design (no rollback possible)