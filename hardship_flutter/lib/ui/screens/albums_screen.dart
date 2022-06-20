import 'package:flutter/material.dart';
import 'package:hardship_flutter/ui/constants/app_constants.dart';
import 'package:hardship_flutter/ui/widgets/app_large_text.dart';
import 'package:hardship_flutter/ui/widgets/app_text.dart';

class AlbumsScreen extends StatefulWidget {
  const AlbumsScreen({Key? key}) : super(key: key);

  @override
  State<AlbumsScreen> createState() => _AlbumsScreenState();
}

class _AlbumsScreenState extends State<AlbumsScreen>
    with TickerProviderStateMixin {
  late TabController _tabController;

  @override
  void initState() {
    super.initState();
    _tabController = TabController(length: 2, vsync: this);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        automaticallyImplyLeading: true,
      ),
      body: SafeArea(
        child: Container(
          padding: const EdgeInsets.only(
              left: kDefaultPadding, right: kDefaultPadding),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.start,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [const AppLargeText(text: 'Albums'), _tabBar(context)],
          ),
        ),
      ),
    );
  }

  Widget _tabBarView() {
    return SizedBox(
      height: 300,
      width: double.infinity,
      child: TabBarView(
        controller: _tabController,
        children: [
          const Text('Album 1'),
          const Text('Album 2'),
          const Text('Album 3'),
        ],
      ),
    );
  }

  Widget _tabBar(BuildContext context) {
    return Container(
      height: 50,
      alignment: Alignment.centerLeft,
      child: TabBar(
        controller: _tabController,
        isScrollable: true,
        labelPadding: EdgeInsets.only(right: 20),
        unselectedLabelColor: Theme.of(context).unselectedWidgetColor,
        labelColor: Theme.of(context).colorScheme.primary,
        tabs: const <Widget>[
          Tab(
            text: 'Artitsta',
          ),
          Tab(
            text: 'Etichetta',
          ),
        ],
      ),
    );
  }
}
