public class FingerprintModule {
    private String fingerprintSerialNumber;
    private String fingerprint;

    public FingerprintModule(String fingerprintSerialNumber) {
        this.fingerprintSerialNumber = fingerprintSerialNumber;
        }
    
    public void registerFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
        }

    public boolean checkFingerprint(String fingerprint) {
        if (fingerprint.equals(this.fingerprint)) {
            return true;
        } else {
            return false;
        }
    }

    public String getFingerprintSerialNumber() {
        return fingerprintSerialNumber;
    }
}
