package io.github.waterdev.fileshare;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import io.github.waterdev.fileshare.Utils.Parser;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;

public class FileShare {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static String pasx = "baum";

    public static String encodeUsingApacheCommons(byte[] bytes) { return Hex.encodeHexString(bytes); }
    public static byte[] decodeUsingApacheCommons(String hexString) throws DecoderException { return Hex.decodeHex(hexString.toCharArray()); }

    static void writeByte(byte[] bytes, String FILEPATH) {
        try {
            File file = new File(FILEPATH);
            OutputStream os = new FileOutputStream(file);

            os.write(bytes);
            System.out.println("Successfully byte inserted");

            os.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public static void main(String[] args) {
        try {
            FileShare run = new FileShare();

            System.out.println("O^O Thx for using this. :3 Please enter the secret of your walletapi.");

            Scanner sc = new Scanner(System.in);
            pasx = sc.next();

            System.out.println("Please enter the ip and port of your walletapi. (Ex: 127.0.0.1:32780)");
            String ipuport = sc.next();

            System.out.println("Do you want to save a File to the Blockchain or load one from the Blockchain?");
            System.out.println("1 for saving (0 for loading): ");
            int ix = sc.nextInt();

            if (ix == 1)
            {
                System.out.println("Good you want to save something.");
                System.out.println("Please enter the full path of your wallet (without ending)");
                String name = sc.next();

                System.out.println("Now enter the password.");
                String password = sc.next();

                run.useWallet("http://" + ipuport + "/wallet/open", name, password);

                System.out.println("Now create a fresh Wallet. NOTE: Don't use this wallet for something else INCLUDING mining, optimizing or transacting from or to it!! Else the file will break.");
                System.out.println("Please enter the address of it.");
                String address = sc.next();

                System.out.println(" ");
                System.out.println("Now we start the sending chapter :)");
                System.out.println(" ");

                System.out.println("TIP: Make an archive out of your file like .tar.gz or tar.xz on Linux or .rar or .zip on Windows.");
                System.out.println("Now please enter the full path to your File.");
                String filepath = sc.next();

                File file = new File(filepath);
                byte[] bytes = readContentIntoByteArray(file);
                String hex = encodeUsingApacheCommons(bytes);
                List<String> strings = new ArrayList<String>();
                int index = 0;

                while (index < hex.length()) {
                    strings.add(hex.substring(index, Math.min(index + 16, hex.length())));
                    index += 16;
                }

                int temp = 0;
                List<String> lex = new ArrayList<String>();

                for (String k : strings) {
                    temp++;

                    int length = String.valueOf(temp).length();
                    String lll = "";

                    for (int len = 15 - length; len > 0; len--)
                    {
                        lll = lll + "0";
                    }

                    String lol = lll + temp + "-" + k;
                    System.out.println("xxxxx: " + lol);
                    lex.add(lol);
                }

                int note = 0;
                for (String k : lex) {
                    note++;

                    System.out.println("It is still loading up.. " + note);
                    String y = encodeUsingApacheCommons(k.getBytes());

                    if (y.length() < 64) {
                        int g = y.length();
                        for (int p = 64 - g; p > 0; p--)
                        {
                            y = "0" + y;
                        }
                    }

                    TimeUnit.SECONDS.sleep(5L);

                    run.sendtrans("http://" + ipuport + "/transactions/send/basic", address, y);
                }

                System.out.println("Loaded up to the chain! c: Have Fun 0^0");
            }
            else
            {
                System.out.println("Good you want to load something. Please place the file wallet in the directory of your jar and the WalletAPI.");
                System.out.println("Please enter the name of your wallet (without ending)");
                String name = sc.next();

                System.out.println("Now enter the password.");
                String password = sc.next();

                run.useWallet("http://" + ipuport + "/wallet/open", name, password);

                System.out.println("Please enter the full path where you want your file to be saved. (Ex: C:/test.mp3)");
                String filepath = sc.next();

                String json = run.get("http://" + ipuport + "/transactions");
                List<String> ids = new Parser().parseJSONtoList(json);
                List<String> lex = new ArrayList<String>();

                for (String i : ids) {
                    byte[] bytes = decodeUsingApacheCommons(i);
                    String baum = new String(bytes);

                    System.out.println(baum);
                    lex.add(baum);
                }

                Collections.sort(lex, new Comparator<String>()
                {
                    int count2 = 0;

                    public int compare(String o1, String o2) {
                        this.count2++;
                        System.out.println("Sorting.. " + this.count2);
                        return extractInt(o1) - extractInt(o2);
                    }

                    int extractInt(String s) {
                        String[] ppp = s.split("-");
                        String num = ppp[0].replaceAll("\\D", "");
                        return num.isEmpty() ? 0 : Integer.parseInt(num);
                    }
                });

                String decodepls = "";
                int count = 0;
                for (String k : lex) {
                    count++;

                    String[] kp = k.split("-");
                    decodepls = decodepls + kp[1];
                    System.out.println("Adding.. " + count);
                }

                byte[] byteo = decodeUsingApacheCommons(decodepls);
                writeByte(byteo, filepath);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static byte[] readContentIntoByteArray(File file) {
        FileInputStream fileInputStream = null;
        byte[] bFile = new byte[(int)file.length()];

        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
            for (int i = 0; i < bFile.length; i++) {
                System.out.print((char)bFile[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bFile;
    }


    public static void writeFile(String texttowrite, String Filexy) {
        BufferedWriter writer = null;
        try {
            File logFile = new File(Filexy);
            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write(texttowrite);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private void close() throws IOException { this.httpClient.close(); }

    public void useWallet(String url, String name, String passwd) throws Exception {
        HttpPost request = new HttpPost(url);
        request.addHeader("x-api-key", pasx);

        JSONObject obj = new JSONObject();
        obj.put("daemonHost", "127.0.0.1");
        obj.put("daemonPort", new Integer(11441));
        obj.put("filename", name + ".wallet");
        obj.put("password", passwd);

        String jte = String.valueOf(obj);
        StringEntity json = new StringEntity(jte);
        request.setEntity(json);

        try(CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(request)) {
            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }

    public String getpay(String url, String s) throws Exception {
        HttpPost request = new HttpPost(url);
        request.addHeader("x-api-key", pasx);
        request.addHeader("Content-Type", "application/json");

        StringEntity json = new StringEntity(s);
        request.setEntity(json);

        try(CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(request)) {
            String debugtemp = EntityUtils.toString(response.getEntity());
            System.out.println(debugtemp);
            return debugtemp;
        }
    }

    private void sendtrans(String url, String address, String paymentid) throws Exception {
        HttpPost request = new HttpPost(url);
        request.addHeader("x-api-key", pasx);

        JSONObject obj = new JSONObject();

        obj.put("destination", address);
        obj.put("paymentID", paymentid);
        obj.put("amount", 1);

        String jte = String.valueOf(obj);
        StringEntity json = new StringEntity(jte);

        request.setEntity(json);
        try(CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(request)) {
            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }



    private String get(String url) throws Exception {
        HttpGet request = new HttpGet(url);
        request.addHeader("x-api-key", pasx);

        try (CloseableHttpResponse response = this.httpClient.execute(request)) {
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println(headers);

            String result = EntityUtils.toString(entity);
            System.out.println(result);
            return result;
        }
    }

    private void sendPost(String url) throws Exception {
        HttpPost post = new HttpPost(url);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("username", "abc"));
        urlParameters.add(new BasicNameValuePair("password", "123"));
        urlParameters.add(new BasicNameValuePair("custom", "secret"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));
        try(CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(post)) {
            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }


    public static String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
}
