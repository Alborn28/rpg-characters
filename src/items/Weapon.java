package items;

import items.enumerations.ItemSlot;
import items.enumerations.WeaponType;

public class Weapon extends Item {
    WeaponType weaponType;
    int damage;
    double attackSpeed;

    public Weapon(String name, int requiredLevel, ItemSlot slot, WeaponType weaponType, int damage, double attackSpeed) {
        super(name, requiredLevel, slot);

        if(damage < 1) {
            throw new IllegalArgumentException("Damage must be positive");
        }

        if(attackSpeed <= 0) {
            throw new IllegalArgumentException("Attack speed must be positive!");
        }

        this.weaponType = weaponType;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public double getDPS() {
        return damage * attackSpeed;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(super.toString() + "\n");
        result.append("Weapon type: " + getWeaponType() + "\n");
        result.append("Damage: " + getDamage() + "\n");
        result.append("Attack speed: " + getAttackSpeed() + "\n");
        result.append("DPS: " + getDPS());

        return result.toString();
    }
}
