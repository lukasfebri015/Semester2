{
  "nbformat": 4,
  "nbformat_minor": 0,
  "metadata": {
    "colab": {
      "provenance": [],
      "authorship_tag": "ABX9TyPuTmqSxKHSp6EDRaFa0U24",
      "include_colab_link": true
    },
    "kernelspec": {
      "name": "python3",
      "display_name": "Python 3"
    },
    "language_info": {
      "name": "python"
    }
  },
  "cells": [
    {
      "cell_type": "markdown",
      "metadata": {
        "id": "view-in-github",
        "colab_type": "text"
      },
      "source": [
        "<a href=\"https://colab.research.google.com/github/lukasfebri015/Semester2/blob/main/Encrypt.java\" target=\"_parent\"><img src=\"https://colab.research.google.com/assets/colab-badge.svg\" alt=\"Open In Colab\"/></a>"
      ]
    },
    {
      "cell_type": "markdown",
      "source": [
        "Berikut adalah 3 buah enkripsi klasik dan 1 buah enkripsi modern beserta implementasinya pada Java:\n",
        "\n",
        "1. Caesar Cipher\n",
        "\n",
        "Caesar Cipher adalah salah satu algoritma enkripsi klasik yang paling sederhana. Algoritma ini menggeser setiap huruf pada pesan sejauh n kali, dengan n merupakan kunci enkripsi. Berikut adalah contoh implementasi Caesar Cipher pada Java:\n",
        "\n",
        "```java\n",
        "public static String encryptCaesar(String plainText, int shift) {\n",
        "    StringBuilder cipherText = new StringBuilder();\n",
        "    for (int i = 0; i < plainText.length(); i++) {\n",
        "        char ch = (char) (((int) plainText.charAt(i) + shift - 65) % 26 + 65);\n",
        "        cipherText.append(ch);\n",
        "    }\n",
        "    return cipherText.toString();\n",
        "}\n",
        "```\n",
        "\n",
        "2. Vigenere Cipher\n",
        "\n",
        "Vigenere Cipher adalah algoritma enkripsi klasik yang menggunakan tabel Vigenere untuk mengenkripsi pesan. Tabel ini terdiri dari 26 baris dan 26 kolom, di mana setiap baris dan kolom mewakili alfabet A-Z. Berikut adalah contoh implementasi Vigenere Cipher pada Java:\n",
        "\n",
        "```java\n",
        "public static String encryptVigenere(String plainText, String key) {\n",
        "    StringBuilder cipherText = new StringBuilder();\n",
        "    int keyIndex = 0;\n",
        "    for (int i = 0; i < plainText.length(); i++) {\n",
        "        char ch = (char) (((int) plainText.charAt(i) + (int) key.charAt(keyIndex) - 2 * 65) % 26 + 65);\n",
        "        cipherText.append(ch);\n",
        "        keyIndex = ++keyIndex % key.length();\n",
        "    }\n",
        "    return cipherText.toString();\n",
        "}\n",
        "```\n",
        "\n",
        "3. Hill Cipher\n",
        "\n",
        "Hill Cipher adalah algoritma enkripsi klasik yang menggunakan matriks sebagai kunci enkripsi. Algoritma ini mengenkripsi pesan dengan membagi pesan menjadi blok-blok huruf, kemudian mengalikan setiap blok dengan matriks kunci. Berikut adalah contoh implementasi Hill Cipher pada Java:\n",
        "\n",
        "```java\n",
        "public static String encryptHill(String plainText, int[][] key) {\n",
        "    StringBuilder cipherText = new StringBuilder();\n",
        "    int n = key.length;\n",
        "    int[] plainTextVector = new int[n];\n",
        "    for (int i = 0; i < plainText.length(); i += n) {\n",
        "        for (int j = 0; j < n; j++) {\n",
        "            plainTextVector[j] = plainText.charAt(i + j) - 65;\n",
        "        }\n",
        "        for (int j = 0; j < n; j++) {\n",
        "            int sum = 0;\n",
        "            for (int k = 0; k < n; k++) {\n",
        "                sum += key[j][k] * plainTextVector[k];\n",
        "            }\n",
        "            cipherText.append((char) ((sum % 26) + 65));\n",
        "        }\n",
        "    }\n",
        "    return cipherText.toString();\n",
        "}\n",
        "```\n",
        "\n",
        "4. Advanced Encryption Standard (AES)\n",
        "\n",
        "Advanced Encryption Standard (AES) adalah algoritma enkripsi modern yang digunakan secara luas untuk mengamankan data. AES menggunakan blok cipher dengan ukuran blok 128 bit dan kunci enkripsi dengan panjang 128, 192, atau 256 bit. Berikut adalah contoh implementasi AES pada Java menggunakan library Bouncy Castle:\n",
        "\n",
        "```java\n",
        "import org.bouncycastle.crypto.BlockCipher;\n",
        "import org.bouncycastle.crypto.engines.AESEngine;\n",
        "import org.bouncycastle.crypto.modes.CBCBlockCipher;\n",
        "import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;\n",
        "import org.bouncycastle.crypto.params.KeyParameter;\n",
        "import org.bouncycastle.crypto.params.ParametersWithIV;\n",
        "\n",
        "public static byte[] encryptAES(byte[] plainText, byte[] key, byte[] iv) throws Exception {\n",
        "    BlockCipher engine = new AESEngine();\n",
        "    CBCBlockCipher cipher = new CBCBlockCipher(engine);\n",
        "    PaddedBufferedBlockCipher paddedCipher = new PaddedBufferedBlockCipher(cipher);\n",
        "    KeyParameter keyParam = new KeyParameter(key);\n",
        "    ParametersWithIV params = new ParametersWithIV(keyParam, iv);\n",
        "    paddedCipher.init(true, params);\n",
        "    byte[] cipherText = new byte[paddedCipher.getOutputSize(plainText.length)];\n",
        "    int outputLen = paddedCipher.processBytes(plainText, 0, plainText.length, cipherText, 0);\n",
        "    paddedCipher.doFinal(cipherText, outputLen);\n",
        "    return cipherText;\n",
        "}\n",
        "```\n"
      ],
      "metadata": {
        "id": "QxkrGZddC0oG"
      }
    }
  ]
}