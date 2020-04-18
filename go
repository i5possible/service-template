#!/usr/bin/env bash


set -e

if [ $# = 0 ]; then
  echo "
  Usage: ./go.sh [commands]

  Commands:
    generate-schema             Generate database schema file to src/main/resources/schema.sql
    generate-migration filename Generate database migration file to src/main/resources/db/migration/{filename}.sql
"
  exit 1
fi

generate_schema()  {
  rm -f ./src/main/resources/schema.sql
  echo 'Press Ctrl-C to stop application after started'
  ./gradlew bootRun --args='--spring.profiles.active=schema-generation' || true
}

generate_migration() {
  if [ -z "$1" ]; then
      echo "filename required"
      exit 1
  fi
  rm -f ./src/main/resources/migration.sql
  echo 'Press Ctrl-C to stop application after started'
  ./gradlew bootRun --args='--spring.profiles.active=migration-generation' || true
  mv ./src/main/resources/migration.sql ./src/main/resources/db/migration/"${1}".sql

  read -r -p "Press enter to generate schema (Or Ctrl-C to exit):"
  generate_schema
}

case $1 in
generate-schema)
  generate_schema
  ;;
generate-migration)
  generate_migration "$2"
  ;;
*)
  echo "command not found"
  ;;
esac
