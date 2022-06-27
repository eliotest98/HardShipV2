import 'package:flutter/material.dart';

class AlbumDetails extends StatefulWidget {
  const AlbumDetails({Key? key}) : super(key: key);

  @override
  State<AlbumDetails> createState() => _AlbumDetailsState();
}

class _AlbumDetailsState extends State<AlbumDetails> {
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            GestureDetector(
                onTap: () {
                  Navigator.pop(context);
                },
                child: Padding(
                  padding: const EdgeInsets.only(left: 20.0, top: 50.0),
                  child: Icon(
                    Icons.arrow_back_ios,
                    color: Colors.black,
                  ),
                )),
            Center(
              child: Padding(
                padding:
                    const EdgeInsets.only(top: 40.0, left: 20.0, right: 20.0),
                child: Container(
                  height: 100,
                  child: Stack(
                    children: <Widget>[
                      ClipRRect(
                        borderRadius: BorderRadius.circular(20.0),
                        child: Image.asset(
                          "assets/png/holliwood.png",
                          fit: BoxFit.cover,
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            ),
            Padding(
              padding: const EdgeInsets.only(left: 20.0, top: 30.0),
              child: Text(
                "Post Malone",
                style: TextStyle(
                    color: Colors.black,
                    fontFamily: 'Nunito-Bold',
                    fontSize: 20),
              ),
            ),
            Padding(
              padding: const EdgeInsets.only(left: 20.0, top: 5.0),
              child: Text(
                "Holliwood's Bleeding",
                style: TextStyle(
                    color: Colors.grey,
                    fontFamily: 'Nunito-Regular',
                    fontSize: 20),
              ),
            ),
            Padding(
              padding: const EdgeInsets.only(
                  left: 20.0, right: 20.0, top: 30.0, bottom: 20.0),
              child: Container(
                child: Column(
                  children: <Widget>[
                    artistSongs("assets/png/spiderman_album.png", "Sunflower",
                        "Post Malone e Swae Lee", "2:37"),
                    SizedBox(
                      height: 20.0,
                    ),
                    GestureDetector(
                      onTap: () {},
                      child: artistSongs("assets/png/spiderman_album.png",
                          "Sunflower", "Post Malone e Swae Lee", "2:37"),
                    ),
                    SizedBox(
                      height: 20.0,
                    ),
                    artistSongs("assets/png/spiderman_album.png", "Sunflower",
                        "Post Malone e Swae Lee", "2:37"),
                    SizedBox(
                      height: 20.0,
                    ),
                    artistSongs("assets/png/spiderman_album.png", "Sunflower",
                        "Post Malone e Swae Lee", "2:37"),
                  ],
                ),
              ),
            )
          ],
        ),
      ),
    );
  }

  artistSongs(String asset, String albumName, String artist, String duration) {
    return Container(
      child: Row(
        children: <Widget>[
          ClipRRect(
            borderRadius: BorderRadius.circular(10.0),
            child: Image.asset(
              asset,
              fit: BoxFit.cover,
              height: 50,
              width: 50,
            ),
          ),
          SizedBox(
            width: 20.0,
          ),
          Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: <Widget>[
              Text(
                albumName,
                style: TextStyle(
                    fontFamily: 'Nunito',
                    fontSize: 20,
                    color: Colors.black,
                    fontWeight: FontWeight.bold),
              ),
              Text(
                artist,
                style: TextStyle(
                  fontFamily: 'Nunito',
                  fontSize: 20,
                  color: Colors.black,
                ),
              ),
            ],
          ),
          Spacer(),
          Text(
            duration,
            style: TextStyle(
                fontFamily: 'Nunito', fontSize: 20, color: Colors.black),
          ),
          SizedBox(
            width: 20.0,
          ),
        ],
      ),
    );
  }
}
