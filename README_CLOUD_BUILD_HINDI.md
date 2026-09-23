# Go Pigeon V1 — Cloud Build

यह पैकेज GitHub Actions से Android APK बनाने के लिए तैयार है।

## जरूरी बात
यह V1 अभी UI/prototype है। Supabase और वास्तविक AI/anonymous messaging अभी इसमें जोड़े नहीं गए हैं। पहले APK बनाकर फोन में चलाएँगे, फिर Supabase जोड़ेंगे।

## GitHub में डालने के बाद
1. Repository की branch `main` में ये सभी files/folders मौजूद होने चाहिए।
2. GitHub में **Actions** खोलें।
3. **Build Go Pigeon V1 APK** workflow चुनें।
4. **Run workflow** दबाएँ।
5. Build पूरा होने पर workflow के नीचे **Artifacts** में `GoPigeonV1-APK` मिलेगा।
6. उसे डाउनलोड करके `app-debug.apk` निकालकर Android फोन में install करें।

अगर `push` के बाद workflow अपने-आप चला, तो अलग से Run workflow की जरूरत नहीं।
