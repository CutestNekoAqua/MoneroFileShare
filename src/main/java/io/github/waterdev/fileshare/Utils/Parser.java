package io.github.waterdev.fileshare.Utils;

import com.google.gson.Gson;
import io.github.waterdev.fileshare.Objects.Transaction;
import io.github.waterdev.fileshare.Objects.Transactions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<String> parseJSONtoList(String json) {
        JSONParser parser = new JSONParser();
        Transactions transactions = null;
        Gson gson = new Gson(); // Creates new instance of Gson

        try {
            transactions = gson.fromJson (json, Transactions.class);;
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> paymentIDs = new ArrayList<String>();
        for (Transaction transaction : transactions.transactions
             ) {
            paymentIDs.add(transaction.paymentID);
        }
        return paymentIDs;
    }

    // Unit testing

    public String test = "{\n" +
            "    \"transactions\": [\n" +
            "        {\n" +
            "            \"blockHeight\": 64909,\n" +
            "            \"fee\": 1000,\n" +
            "            \"hash\": \"e9b7bb8aadd2afa6e120cb0616f382b3b97c3d61668776a545f2b22d8cdb34f9\",\n" +
            "            \"isCoinbaseTransaction\": false,\n" +
            "            \"paymentID\": \"3030303030303030303030303030332d36653230373736393734363832303637\",\n" +
            "            \"timestamp\": 1601384190,\n" +
            "            \"transfers\": [\n" +
            "                {\n" +
            "                    \"address\": \"ind1CWMfrVRKPMzxAcqEy74242FXSapZBEMUsSFDuc8zfVNT95rYXSpFMNyde5vxAbVscDjwHth7YLSHmHK6ER7V1aJyx2qquW\",\n" +
            "                    \"amount\": 1233\n" +
            "                }\n" +
            "            ],\n" +
            "            \"unlockTime\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"blockHeight\": 64909,\n" +
            "            \"fee\": 1000,\n" +
            "            \"hash\": \"ff4741b546921331b2fd56b862f860af08f5f2a0399145875d0560bbc4c5a4c9\",\n" +
            "            \"isCoinbaseTransaction\": false,\n" +
            "            \"paymentID\": \"3030303030303030303030303030342d36313739323036393665373436353732\",\n" +
            "            \"timestamp\": 1601384190,\n" +
            "            \"transfers\": [\n" +
            "                {\n" +
            "                    \"address\": \"ind1CWMfrVRKPMzxAcqEy74242FXSapZBEMUsSFDuc8zfVNT95rYXSpFMNyde5vxAbVscDjwHth7YLSHmHK6ER7V1aJyx2qquW\",\n" +
            "                    \"amount\": 1233\n" +
            "                }\n" +
            "            ],\n" +
            "            \"unlockTime\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"blockHeight\": 64909,\n" +
            "            \"fee\": 1000,\n" +
            "            \"hash\": \"6cbbfcf01c9c1e800a5fdddc9429c63ee9ebea1bf2993e6ff0cad3d6c5ff03ea\",\n" +
            "            \"isCoinbaseTransaction\": false,\n" +
            "            \"paymentID\": \"3030303030303030303030303030312d34393230363136643230363132303637\",\n" +
            "            \"timestamp\": 1601384190,\n" +
            "            \"transfers\": [\n" +
            "                {\n" +
            "                    \"address\": \"ind1CWMfrVRKPMzxAcqEy74242FXSapZBEMUsSFDuc8zfVNT95rYXSpFMNyde5vxAbVscDjwHth7YLSHmHK6ER7V1aJyx2qquW\",\n" +
            "                    \"amount\": 1233\n" +
            "                }\n" +
            "            ],\n" +
            "            \"unlockTime\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"blockHeight\": 64909,\n" +
            "            \"fee\": 750,\n" +
            "            \"hash\": \"ff6f96d97ff466cfcc9de0d180d790c173af0c809b96bd040c7c36efa0b83ad2\",\n" +
            "            \"isCoinbaseTransaction\": false,\n" +
            "            \"paymentID\": \"3030303030303030303030303030352d37323635373337343733326532303534\",\n" +
            "            \"timestamp\": 1601384190,\n" +
            "            \"transfers\": [\n" +
            "                {\n" +
            "                    \"address\": \"ind1CWMfrVRKPMzxAcqEy74242FXSapZBEMUsSFDuc8zfVNT95rYXSpFMNyde5vxAbVscDjwHth7YLSHmHK6ER7V1aJyx2qquW\",\n" +
            "                    \"amount\": 1233\n" +
            "                }\n" +
            "            ],\n" +
            "            \"unlockTime\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"blockHeight\": 64909,\n" +
            "            \"fee\": 1000,\n" +
            "            \"hash\": \"fd0b20ffd3bf2d4d5fb9c9d3dfc9bbe8dbfd6454ef469668ee15180c67aa3577\",\n" +
            "            \"isCoinbaseTransaction\": false,\n" +
            "            \"paymentID\": \"3030303030303030303030303030322d36313739323037303635373237333666\",\n" +
            "            \"timestamp\": 1601384190,\n" +
            "            \"transfers\": [\n" +
            "                {\n" +
            "                    \"address\": \"ind1CWMfrVRKPMzxAcqEy74242FXSapZBEMUsSFDuc8zfVNT95rYXSpFMNyde5vxAbVscDjwHth7YLSHmHK6ER7V1aJyx2qquW\",\n" +
            "                    \"amount\": 1233\n" +
            "                }\n" +
            "            ],\n" +
            "            \"unlockTime\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"blockHeight\": 64910,\n" +
            "            \"fee\": 750,\n" +
            "            \"hash\": \"b17ff79b615473f9f6208c5469200d9da2bc572ad849c4cfc71ea51447f75732\",\n" +
            "            \"isCoinbaseTransaction\": false,\n" +
            "            \"paymentID\": \"3030303030303030303030303030362d36383639373332303737363936633663\",\n" +
            "            \"timestamp\": 1601384192,\n" +
            "            \"transfers\": [\n" +
            "                {\n" +
            "                    \"address\": \"ind1CWMfrVRKPMzxAcqEy74242FXSapZBEMUsSFDuc8zfVNT95rYXSpFMNyde5vxAbVscDjwHth7YLSHmHK6ER7V1aJyx2qquW\",\n" +
            "                    \"amount\": 1233\n" +
            "                }\n" +
            "            ],\n" +
            "            \"unlockTime\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"blockHeight\": 64910,\n" +
            "            \"fee\": 750,\n" +
            "            \"hash\": \"a0f89f35fccfa8ca2e02e7da146ebcf1797dabb3c48456c86c9e4a69d8076714\",\n" +
            "            \"isCoinbaseTransaction\": false,\n" +
            "            \"paymentID\": \"3030303030303030303030303030372d32303632363532303631323036633666\",\n" +
            "            \"timestamp\": 1601384192,\n" +
            "            \"transfers\": [\n" +
            "                {\n" +
            "                    \"address\": \"ind1CWMfrVRKPMzxAcqEy74242FXSapZBEMUsSFDuc8zfVNT95rYXSpFMNyde5vxAbVscDjwHth7YLSHmHK6ER7V1aJyx2qquW\",\n" +
            "                    \"amount\": 1233\n" +
            "                }\n" +
            "            ],\n" +
            "            \"unlockTime\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"blockHeight\": 64910,\n" +
            "            \"fee\": 750,\n" +
            "            \"hash\": \"8455d4c721091f722303a095126ec5d7a6ed67438db5b20950f2943dd0b7617d\",\n" +
            "            \"isCoinbaseTransaction\": false,\n" +
            "            \"paymentID\": \"3030303030303030303030303030382d36653637326332303663366636663666\",\n" +
            "            \"timestamp\": 1601384192,\n" +
            "            \"transfers\": [\n" +
            "                {\n" +
            "                    \"address\": \"ind1CWMfrVRKPMzxAcqEy74242FXSapZBEMUsSFDuc8zfVNT95rYXSpFMNyde5vxAbVscDjwHth7YLSHmHK6ER7V1aJyx2qquW\",\n" +
            "                    \"amount\": 1233\n" +
            "                }\n" +
            "            ],\n" +
            "            \"unlockTime\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"blockHeight\": 64910,\n" +
            "            \"fee\": 750,\n" +
            "            \"hash\": \"60bb5a6a2bf04e8c2892f5a814c922d729fe8c506e47992ec1b4a49902db35ae\",\n" +
            "            \"isCoinbaseTransaction\": false,\n" +
            "            \"paymentID\": \"3030303030303030303030303030392d36663666366636653637323036613666\",\n" +
            "            \"timestamp\": 1601384192,\n" +
            "            \"transfers\": [\n" +
            "                {\n" +
            "                    \"address\": \"ind1CWMfrVRKPMzxAcqEy74242FXSapZBEMUsSFDuc8zfVNT95rYXSpFMNyde5vxAbVscDjwHth7YLSHmHK6ER7V1aJyx2qquW\",\n" +
            "                    \"amount\": 1233\n" +
            "                }\n" +
            "            ],\n" +
            "            \"unlockTime\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"blockHeight\": 64911,\n" +
            "            \"fee\": 1000,\n" +
            "            \"hash\": \"eaf50568a02d6280c314776f6908e5c0840a4e96984d7a544bd6669ef5b96aa2\",\n" +
            "            \"isCoinbaseTransaction\": false,\n" +
            "            \"paymentID\": \"3030303030303030303030303031342d32303264336532303231323263326137\",\n" +
            "            \"timestamp\": 1601384203,\n" +
            "            \"transfers\": [\n" +
            "                {\n" +
            "                    \"address\": \"ind1CWMfrVRKPMzxAcqEy74242FXSapZBEMUsSFDuc8zfVNT95rYXSpFMNyde5vxAbVscDjwHth7YLSHmHK6ER7V1aJyx2qquW\",\n" +
            "                    \"amount\": 1233\n" +
            "                }\n" +
            "            ],\n" +
            "            \"unlockTime\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"blockHeight\": 64911,\n" +
            "            \"fee\": 1000,\n" +
            "            \"hash\": \"869f67913f8d5fa9e484b252ee3a8b81653c94a016c9d6cfc53bb95a5be61c7d\",\n" +
            "            \"isCoinbaseTransaction\": false,\n" +
            "            \"paymentID\": \"3030303030303030303030303031332d63336134323063336263323063336236\",\n" +
            "            \"timestamp\": 1601384203,\n" +
            "            \"transfers\": [\n" +
            "                {\n" +
            "                    \"address\": \"ind1CWMfrVRKPMzxAcqEy74242FXSapZBEMUsSFDuc8zfVNT95rYXSpFMNyde5vxAbVscDjwHth7YLSHmHK6ER7V1aJyx2qquW\",\n" +
            "                    \"amount\": 1233\n" +
            "                }\n" +
            "            ],\n" +
            "            \"unlockTime\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"blockHeight\": 64911,\n" +
            "            \"fee\": 750,\n" +
            "            \"hash\": \"0652176d4361059eb33df25a8ea0380c3abf2aefd5d4cd9488c7b0f6bee67709\",\n" +
            "            \"isCoinbaseTransaction\": false,\n" +
            "            \"paymentID\": \"3030303030303030303030303031302d37353732366536353739323037343666\",\n" +
            "            \"timestamp\": 1601384203,\n" +
            "            \"transfers\": [\n" +
            "                {\n" +
            "                    \"address\": \"ind1CWMfrVRKPMzxAcqEy74242FXSapZBEMUsSFDuc8zfVNT95rYXSpFMNyde5vxAbVscDjwHth7YLSHmHK6ER7V1aJyx2qquW\",\n" +
            "                    \"amount\": 1233\n" +
            "                }\n" +
            "            ],\n" +
            "            \"unlockTime\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"blockHeight\": 64911,\n" +
            "            \"fee\": 750,\n" +
            "            \"hash\": \"cfd0573b8f4f614194c778bdfa69902e318112d7f0c4f20960efa201cf031457\",\n" +
            "            \"isCoinbaseTransaction\": false,\n" +
            "            \"paymentID\": \"3030303030303030303030303031312d32303634363536313734363832653064\",\n" +
            "            \"timestamp\": 1601384203,\n" +
            "            \"transfers\": [\n" +
            "                {\n" +
            "                    \"address\": \"ind1CWMfrVRKPMzxAcqEy74242FXSapZBEMUsSFDuc8zfVNT95rYXSpFMNyde5vxAbVscDjwHth7YLSHmHK6ER7V1aJyx2qquW\",\n" +
            "                    \"amount\": 1233\n" +
            "                }\n" +
            "            ],\n" +
            "            \"unlockTime\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"blockHeight\": 64911,\n" +
            "            \"fee\": 750,\n" +
            "            \"hash\": \"15246908a54ccea270dd6791adf28624c11cead9451d2c84195ca79f5bee4840\",\n" +
            "            \"isCoinbaseTransaction\": false,\n" +
            "            \"paymentID\": \"3030303030303030303030303031322d30616333613463336263633362363230\",\n" +
            "            \"timestamp\": 1601384203,\n" +
            "            \"transfers\": [\n" +
            "                {\n" +
            "                    \"address\": \"ind1CWMfrVRKPMzxAcqEy74242FXSapZBEMUsSFDuc8zfVNT95rYXSpFMNyde5vxAbVscDjwHth7YLSHmHK6ER7V1aJyx2qquW\",\n" +
            "                    \"amount\": 1233\n" +
            "                }\n" +
            "            ],\n" +
            "            \"unlockTime\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"blockHeight\": 64912,\n" +
            "            \"fee\": 1000,\n" +
            "            \"hash\": \"5f87965debc60995b1caa5219d60f2af510d485e19cc5d729ee719c2a9ba1f75\",\n" +
            "            \"isCoinbaseTransaction\": false,\n" +
            "            \"paymentID\": \"3030303030303030303030303031362d36303261376532373233323063336161\",\n" +
            "            \"timestamp\": 1601384222,\n" +
            "            \"transfers\": [\n" +
            "                {\n" +
            "                    \"address\": \"ind1CWMfrVRKPMzxAcqEy74242FXSapZBEMUsSFDuc8zfVNT95rYXSpFMNyde5vxAbVscDjwHth7YLSHmHK6ER7V1aJyx2qquW\",\n" +
            "                    \"amount\": 1233\n" +
            "                }\n" +
            "            ],\n" +
            "            \"unlockTime\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"blockHeight\": 64912,\n" +
            "            \"fee\": 1000,\n" +
            "            \"hash\": \"6a268ee4da158e248b8ded35035de2683750321db4d594f4727da1b6e56fb60c\",\n" +
            "            \"isCoinbaseTransaction\": false,\n" +
            "            \"paymentID\": \"3030303030303030303030303031352d32343235323632663238323933643366\",\n" +
            "            \"timestamp\": 1601384222,\n" +
            "            \"transfers\": [\n" +
            "                {\n" +
            "                    \"address\": \"ind1CWMfrVRKPMzxAcqEy74242FXSapZBEMUsSFDuc8zfVNT95rYXSpFMNyde5vxAbVscDjwHth7YLSHmHK6ER7V1aJyx2qquW\",\n" +
            "                    \"amount\": 1233\n" +
            "                }\n" +
            "            ],\n" +
            "            \"unlockTime\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"blockHeight\": 64912,\n" +
            "            \"fee\": 750,\n" +
            "            \"hash\": \"29d2b0d38303a42c8ff49bf696a0c852f99a45e0d332c2986a0de5bdd5c8357c\",\n" +
            "            \"isCoinbaseTransaction\": false,\n" +
            "            \"paymentID\": \"0000000000003030303030303030303030303031372d32306333613863336139\",\n" +
            "            \"timestamp\": 1601384222,\n" +
            "            \"transfers\": [\n" +
            "                {\n" +
            "                    \"address\": \"ind1CWMfrVRKPMzxAcqEy74242FXSapZBEMUsSFDuc8zfVNT95rYXSpFMNyde5vxAbVscDjwHth7YLSHmHK6ER7V1aJyx2qquW\",\n" +
            "                    \"amount\": 1233\n" +
            "                }\n" +
            "            ],\n" +
            "            \"unlockTime\": 0\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.parseJSONtoList(parser.test);
    }

}
