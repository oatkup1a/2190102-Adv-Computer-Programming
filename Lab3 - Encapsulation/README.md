The door class is given below. Please implement the classes below:

1. `Key` class:
   * Represents a key with a unique `keyID`.
   * Members:
     * `private String keyID`
   * Methods:
     * constructor: Gets `keyID` as parameter and set the `keyID` of this object to be the input `keyID`.

2. `Doorknob` class:
   * Represents a doorknob with a unique `doorknobID`.
   * Members:
     * `private String doorknobID`
   * Methods:
      * constructor: Gets `doorknobID` as parameter and set the `doorknobID` of this object to be the input `doorknobID`.
      * `public boolean canUnlock(Key key)`: Checks if the provided `key` can unlock this `doorknob`. The key with the keyID must be same as the doorknobID will be able to unlock this doorknob. (You must use `s1.equals(s2)` to compare `s1` and `s2`). Return `true` if the input `key` can unlock the doorknob, `false` otherwise.

3. `DoorWithDoorknob` class (inherits from `Door`):
   * Represents a door with an integrated doorknob.
   * Members:
     * `private Doorknob doorknob`;
   * Methods:
     * constructor: Gets `doorID` as parameter and set the `doorID` of this object to be the input `doorID` using the constructor of the superclass.
     * `public void installDoorknob(Doorknob doorknob)`: Installs a doorknob to this door. Once finish print `"A doorknob with ID " + doorknob.getDoorknobID() + " already installed."`
     * `public void unlock(Key key)`: Unlocks the door if the provided key matches the installed doorknob's ID.

4. `FingerprintModule` class:

    * Represents a fingerprint module with attributes fingerprintSerialNumber and fingerprint.
    * Members:
      * `private String fingerprintSerialNumber;`
      * `private String fingerprint;` <= fingerprint data
    * Methods:
      * constructor: Gets `fingerprintSerialNumber` as parameter and set the `fingerprintSerialNumber` of this object to be the input `fingerprintSerialNumber`.
      * `public void registerFingerprint(String fingerprint)`: Set the `fingerprint` of this module to be the input `fingerprint`.
      * `public boolean checkFingerprint(String fingerprint)`: Checks if the provided `fingerprint` matches the registered `fingerprint`.

5. `DoorWithFingerprint` class (inherits from Door):
   * Represents a door with an integrated fingerprint module.
   * Members:
     * `private FingerprintModule fingerprintModule;`
   * Methods:
     * constructor: Gets `doorID` as parameter and set the `doorID` of this object to be the input `doorID` using the constructor of the superclass.
     * `public void installFingerprintModule(FingerprintModule fingerprintModule)`: Installs a fingerprint module to the door. Once finish print `"A fingerprint module with serial " + fingerprintModule.getFingerprintSerialNumber() + " already installed."`
     * `public void close(String fingerprint)`: Closes and locks the door using the provided `fingerprint`.
     * `public void open(String fingerprint)`: Opens the door if the provided fingerprint is valid; otherwise, displays a locked message.


## Door class

```public class Door {
    private String doorID;
    private boolean locked;
    public Door(String doorID) {
        this.doorID = doorID;
        this.locked = false;
    }
    public String getDoorID() {
        return doorID;
    }
    public boolean isLocked() {
        return locked;
    }
    public void lock() {
        locked = true;
        System.out.println("Door "+this.doorID+" is locked.");
    }
    public void unlock() {
        locked = false;
        System.out.println("Door "+this.doorID+" is unlocked.");
    }
    public void open() {
        if (!locked) {
            System.out.println("Door "+this.doorID+" is opened.");
        } else {
            System.out.println("Door "+this.doorID+" cannot be opened. Please unlock the door first.");
        }
    }
    public void close() {
        locked = false;
        System.out.println("Door "+this.doorID+" is closed and unlocked.");
    }
}```


## DoorTest class

```package door;

public class DoorTest {
    public static void main(String[] args) throws Exception {
        DoorWithDoorknob d1 = new DoorWithDoorknob("DoorID1");
        Doorknob dk1 = new Doorknob("DoorknobID1");
        d1.installDoorknob(dk1);
        d1.close();
        d1.lock();
        d1.unlock(new Key("DoorknobID1"));
        d1.open();
        d1.close();
        d1.open();
        d1.lock();
        d1.unlock(new Key("DoorknobID2"));
        d1.open();

        DoorWithFingerprint d2 = new DoorWithFingerprint("DoorID2");
        FingerprintModule f1 = new FingerprintModule("FingerprintSerial001");
        d2.installFingerprintModule(f1);
        d2.close();
        d2.open();
        d2.close("Finger of Somchai");
        d2.open("Finger of Somsak");
        d2.open("Finger of Somchai");
    }
}```


### Expected output

```
A doorknob with ID DoorknobID1 already installed.
Door DoorID1 is closed and unlocked.
Door DoorID1 is locked.
Door DoorID1 is unlocked.
Door DoorID1 is opened.
Door DoorID1 is closed and unlocked.
Door DoorID1 is opened.
Door DoorID1 is locked.
Door DoorID1 cannot be opened. Please unlock the door first.
A fingerprint module with serial FingerprintSerial001 already installed.
Door DoorID2 is closed and unlocked.
Door DoorID2 is opened.
Door DoorID2 is locked.
Door DoorID2 cannot be opened. Please unlock the door first.
Door DoorID2 is unlocked.
Door DoorID2 is opened.
```



