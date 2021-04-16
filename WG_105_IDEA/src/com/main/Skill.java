package com.main;

public class Skill extends Item {

    private String skillType;
    private boolean targetFoe; // apakah skill ini dilancarkan untuk pihak lawan?
    private Integer timestamp; // waktu yang dibutuhkan untuk melancarkan skill
    private GameCharacter tempTarget; // target dari skill

    // Constructor
    public Skill(String vName, String vDescription, String vSkillType, Double vStrengthMultiplier,
                 Double vHealthMultiplier, Double vShieldsMultiplier, boolean vTargetFoe, Integer vTimestamp) {
        super(vName, vDescription);
        this.skillType = vSkillType;
        this.strengthMultiplier = vStrengthMultiplier;
        this.healthMultiplier = vHealthMultiplier;
        this.shieldsMultiplier = vShieldsMultiplier;
        this.targetFoe = vTargetFoe;
        this.timestamp = vTimestamp;
    }

    public Skill(String vName, String vDescription, String vSkillType, Double vStrengthMultiplier, Integer vTimestamp) {
        /*
         * secara default inilah constructor untuk skill yang ditargetkan ke pihak lawan
         * dari pengguna skill ini. Skill ini hanya memiliki daya rusak untuk pihak
         * lawan
         */
        this(vName, vDescription, vSkillType, vStrengthMultiplier, 0.0, 0.0, true, vTimestamp);
    }

    public Skill(String vName, String vDescription, String vSkillType, Double vHealthMultiplier,
                 Double vShieldsMultiplier, Integer vTimestamp) {
        /*
         * secara default inilah constructor untuk skill yang ditargetkan ke pihak kawan
         * dari pengguna skill ini. Skill ini memiliki daya penyembuhan dan perlindungan
         * untuk pihak kawan
         */
        this(vName, vDescription, vSkillType, 0.0, vHealthMultiplier, vShieldsMultiplier, false, vTimestamp);
    }

    // Getter & Setter
    public String getSkillType() { return skillType; }

    public void setSkillType(String vSkillType) { this.skillType = vSkillType; }

    public boolean isTargetFoe() { return targetFoe; }

    public void setTargetFoe(boolean vTargetFoe) { this.targetFoe = vTargetFoe; }

    public Integer getTimestamp() { return timestamp; }

    public void setTimestamp(Integer vTimestamp) { this.timestamp = vTimestamp; }

    public GameCharacter getTempTarget() { return tempTarget; }

    public void setTempTarget(GameCharacter vTempTarget) { tempTarget = vTempTarget; }

    // Methods
    @Override
    public void describe() {
        super.describe();
        System.out.println("Type: " + this.skillType);
        System.out.println("Timestamp: " + this.timestamp);
    }

    public void damageDeal(GameCharacter objCharacter) {
        double damageDeal = (objCharacter.getStrength() * strengthMultiplier);
        setStrengthValue((int) damageDeal);
    }

    public void healPower(GameCharacter objCharacter) {
        double healPower = (objCharacter.getMaxHealth() * healthMultiplier);
        setHealthValue((int) healPower);
    }

    public void defensePower(GameCharacter objCharacter) {
        double defensePower = (objCharacter.getMaxShields() * shieldsMultiplier);
        setShieldsValue((int) defensePower);
    }

    public void calculateSkill(GameCharacter objCharacter) {
        damageDeal(objCharacter);
        healPower(objCharacter);
        defensePower(objCharacter);
    }
}
