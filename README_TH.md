# 9p Discord Lite — สร้าง APK โดยใช้มือถือ Android เครื่องเดียว

## แอปนี้ทำอะไรได้
- เมื่อกดปุ่ม จะเปิดแอป Discord ทางการ (`com.discord`) ถ้าติดตั้งอยู่
- ถ้าไม่มีแอป Discord จะเปิด `https://discord.com/app` ผ่านเบราว์เซอร์
- การโทรเสียง, Voice Channel, mute และ speaker ทำงานในแอป Discord ทางการ
- 9p ไม่อ่านหรือเก็บรหัสผ่าน/Token และไม่ควบคุมระบบเสียงภายใน Discord

## วิธีที่แนะนำ: Build บน GitHub โดยใช้มือถือ
ต้องมีบัญชี GitHub และอินเทอร์เน็ต แต่ไม่ต้องมีคอมพิวเตอร์.

1. ดาวน์โหลด ZIP และแตกไฟล์ด้วยแอปจัดการไฟล์ใน Android
2. เปิด https://github.com แล้วเข้าสู่ระบบ
3. สร้าง repository ใหม่ ตั้งชื่อ `9p-discord-lite` และเลือก Public หรือ Private
4. ในหน้า repository เลือก **Add file > Upload files**
5. อัปโหลดไฟล์และโฟลเดอร์ทั้งหมดจากโปรเจกต์ที่แตก ZIP แล้ว รวมถึงโฟลเดอร์ `.github`
   - ถ้าเว็บมือถือซ่อนโฟลเดอร์ `.github` ให้เปิด **Desktop site** ใน Chrome
6. กด **Commit changes**
7. เปิดแท็บ **Actions** ของ repository
8. เลือก workflow **Build 9p Discord Lite APK** แล้วกด **Run workflow** หากยังไม่เริ่มทำงานเอง
9. รอจนงานเป็นสีเขียว แล้วเปิดรายการงานที่สำเร็จ
10. เลื่อนลงไปที่ **Artifacts** แล้วแตะ `9p-discord-lite-debug-apk` เพื่อดาวน์โหลด ZIP
11. แตก ZIP ที่ดาวน์โหลด จะพบ `app-debug.apk`
12. แตะ APK เพื่อติดตั้ง Android อาจขออนุญาตติดตั้งแอปจากแหล่งนี้

## หมายเหตุ
- GitHub Actions เป็นบริการภายนอก ต้องมีบัญชี GitHub และอาจมีข้อจำกัดการใช้งาน
- APK ที่ได้เป็น debug APK สำหรับทดสอบ ไม่ใช่ release APK ที่ลงนามสำหรับเผยแพร่
- โปรเจกต์นี้เป็นตัวเปิดแอป Discord ทางการ ไม่ใช่ไคลเอนต์ Discord ใหม่ และไม่สามารถทำให้ Discord มีขนาดเล็กลงหรือเปลี่ยนการทำงานของ Voice ภายใน Discord ได้
- หากต้องการโทรเสียง ให้ติดตั้ง Discord ทางการจาก Play Store ก่อน
