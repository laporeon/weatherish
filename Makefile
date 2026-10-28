.DEFAULT_GOAL := help

APP_NAME := weatherish
JAR      := target/weatherish.jar
MVN      ?= ./mvnw
JAVA     ?= java

PROJECT_DIR := $(abspath .)
INSTALL_DIR ?= $(HOME)/.local/bin
LAUNCHER    := $(INSTALL_DIR)/$(APP_NAME)

.PHONY: help env build compile test verify clean run install uninstall

help: ## Show available commands
	@awk 'BEGIN {FS = ":.*## "} /^[a-zA-Z_-]+:.*## / {printf "  \033[36m%-10s\033[0m %s\n", $$1, $$2}' $(MAKEFILE_LIST)

env: ## Create .env from .env.example if missing
	@test -f .env || { cp .env.example .env; echo "Created .env — set your API_KEY before running."; }

build: ## Clean and build the executable JAR
	$(MVN) clean package

compile: ## Compile the project
	$(MVN) compile

test: ## Run the test suite
	$(MVN) test

verify: ## Run Maven verification
	$(MVN) verify

clean: ## Clean Maven build artifacts
	$(MVN) clean

run: env build ## Build and run the application locally
	$(JAVA) -jar $(JAR)

install: env build ## Install the weatherish command
	@mkdir -p "$(INSTALL_DIR)"
	@printf '%s\n' \
		'#!/usr/bin/env sh' \
		'set -e' \
		'cd "$(PROJECT_DIR)"' \
		'exec "$(JAVA)" -jar "$(PROJECT_DIR)/$(JAR)" "$$@"' \
		> "$(LAUNCHER)"
	@chmod +x "$(LAUNCHER)"
	@echo "Installed $(APP_NAME) at $(LAUNCHER)"
	@echo "Make sure $(INSTALL_DIR) is in your PATH."

uninstall: ## Remove the installed weatherish command
	@rm -f "$(LAUNCHER)"
	@echo "Removed $(APP_NAME) from $(LAUNCHER)"