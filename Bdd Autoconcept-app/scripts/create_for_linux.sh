#!/bin/sh

TMP_FILE=$(mktemp)
SQL="$(find 0-database 1-contact 2-stock 3-facturation -type f -name '*.sql' | sort)"

echo "Into file : $TMP_FILE"
cat $SQL > "$TMP_FILE"

mysql -u root -h 127.0.0.1 -p < "$TMP_FILE"
