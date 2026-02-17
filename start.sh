#!/bin/bash

# Cores
GREEN='\033[0;32m'
NC='\033[0m'

echo -e "${GREEN}===> Iniciando aplicação...${NC}"

mvn exec:java -Dexec.mainClass="scraper.app.App" -q