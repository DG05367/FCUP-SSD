package pow;

import java.security.PublicKey;
import java.security.PrivateKey;
import java.util.Base64;
import java.security.Signature;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.SignatureException;

public class Transaction {
    private final String buyer;
    private final String seller;
    private final double amount;
    private byte[] signature;

    public Transaction(String buyer, String seller, double amount) {
        this.buyer = buyer;
        this.seller = seller;
        this.amount = amount;
        this.signature = null;
    }

    public String getBuyer() {
        return buyer;
    }

    public String getSeller() {
        return seller;
    }

    public double getAmount() {
        return amount;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public boolean isValid() {
        try {
            PublicKey publicKey = getPublicKey();  // Retrieve public key of the buyer or use a trusted key store
            Signature verifier = Signature.getInstance("SHA256withRSA");
            verifier.initVerify(publicKey);
            verifier.update(getTransactionData().getBytes());
            return verifier.verify(signature);
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getTransactionData() {
        return Base64.getEncoder().encodeToString((buyer + seller + amount).getBytes());
    }

    public byte[] signTransaction(PrivateKey privateKey) {
        try {
            Signature signer = Signature.getInstance("SHA256withRSA");
            signer.initSign(privateKey);
            signer.update(getTransactionData().getBytes());
            return signer.sign();
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean verifySignature(PublicKey publicKey) {
        try {
            Signature sign = Signature.getInstance("SHA256withRSA");
            sign.initVerify(publicKey);
            String data = buyer + seller + amount;
            sign.update(data.getBytes());
            return sign.verify(signature);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private PublicKey getPublicKey() {
//        try {
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            X509EncodedKeySpec publicKeySpec = keyFactory.getKeySpec(privateKey, X509EncodedKeySpec.class);
//            byte[] publicKeyBytes = publicKeySpec.getEncoded();
//            X509EncodedKeySpec publicKeySpecNew = new X509EncodedKeySpec(publicKeyBytes);
//            PublicKey publicKey = keyFactory.generatePublic(publicKeySpecNew);
//            return publicKey;
//        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    public void generateSignature(PrivateKey privateKey) {
        try {
            Signature sign = Signature.getInstance("SHA256withRSA");
            sign.initSign(privateKey);
            String data = buyer + seller + amount;
            sign.update(data.getBytes());
            this.signature = sign.sign();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
