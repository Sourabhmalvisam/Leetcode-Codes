public class Codec {
    private Map<String, String> shortToLong = new HashMap<>();
    private Map<String, String> longToShort = new HashMap<>();
    private String baseUrl = "http://tinyurl.com/"; // Your base URL

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) {
            return baseUrl + longToShort.get(longUrl);
        }

        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String shortKey = generateRandomKey(characters, 6); // Generate a short key
        while (shortToLong.containsKey(shortKey)) {
            shortKey = generateRandomKey(characters, 6); // Regenerate if the key is already in use
        }

        shortToLong.put(shortKey, longUrl);
        longToShort.put(longUrl, shortKey);

        return baseUrl + shortKey;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String shortKey = shortUrl.substring(baseUrl.length());
        return shortToLong.getOrDefault(shortKey, "");
    }

    private String generateRandomKey(String characters, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(randomIndex));
        }
        return sb.toString();
    }
}
