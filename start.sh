#!/usr/bin/env bash

CAMINHO_BINARIO_JAVA=""
LOCAL_PADRAO_INSTALACAO_JAVA=""

inicializarPrograma() {
    if [ -z "$CAMINHO_BINARIO_JAVA" ]; then
        javac -Xprefer:newer -d src -sourcepath src src/principal/*.java
        java -cp src principal.JogoDaForcaJavaFX > /dev/null
    else
        "$CAMINHO_BINARIO_JAVA"javac -Xprefer:newer -d src -sourcepath src src/principal/*.java
        "$CAMINHO_BINARIO_JAVA"java -cp src principal.JogoDaForcaJavaFX
    fi
}

montarCaminhoBinarioJava() {
    CAMINHO_BINARIO_JAVA="$LOCAL_PADRAO_INSTALACAO_JAVA/$1/bin/"
}

verificarExistenciaJavaCompativelInstalado() {
    local nomeVersaoCompativelInstalada=$(ls "$LOCAL_PADRAO_INSTALACAO_JAVA" | egrep "jdk1.8|jre1.8" | head -n 1)
    if [ -z "$nomeVersaoCompativelInstalada" ]; then
        echo "O Java 8 não está instalado. Por favor, instale o Java antes de prosseguir." >&2
        exit 1
    else
        montarCaminhoBinarioJava "$nomeVersaoCompativelInstalada"
        inicializarPrograma
    fi
}

while getopts "l:" opcao; do
    case $opcao in
    l)
        LOCAL_PADRAO_INSTALACAO_JAVA="$OPTARG"
        ;;
    \?)
        echo "Unico parametro aceito: -l"
        exit 1
        ;;
    esac
done

if [ -z "$LOCAL_PADRAO_INSTALACAO_JAVA" ]; then
  LOCAL_PADRAO_INSTALACAO_JAVA="/c/Program Files/Java"
fi

if [ ! -e "$LOCAL_PADRAO_INSTALACAO_JAVA" ]; then
    echo "O caminho informado não é válido." >&2
    exit 1
fi

if ! command -v java &>/dev/null; then
    echo "O Java não está instalado ou o caminho do binário não está no path do sistema operacional" >&2
    exit 1
fi

java_version=$(java -version 2>&1 | awk -F '"' '/version/ {print $2}')
[[ "$java_version" =~ ^1\.8\..* ]] && inicializarPrograma || verificarExistenciaJavaCompativelInstalado