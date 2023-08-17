package likelion.project.ipet_customer.ui.product

import android.inputmethodservice.Keyboard.Row
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import likelion.project.ipet_customer.R
import likelion.project.ipet_customer.databinding.FragmentProductFoodBinding
import likelion.project.ipet_customer.databinding.RowProductCardBinding
import likelion.project.ipet_customer.ui.main.MainActivity

class ProductFoodFragment : Fragment() {

    lateinit var fragmentProductFoodBinding: FragmentProductFoodBinding
    lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentProductFoodBinding = FragmentProductFoodBinding.inflate(inflater)
        mainActivity = activity as MainActivity
        fragmentProductFoodBinding.run {
            recyclerProductList.run {
                adapter = Adapter()
                layoutManager = GridLayoutManager(context, 2)
            }
        }
        return fragmentProductFoodBinding.root
    }

    inner class Adapter: RecyclerView.Adapter<Adapter.Holder>() {
        inner class Holder(rowBinding: RowProductCardBinding): RecyclerView.ViewHolder(rowBinding.root) {
            val imageViewCardThumbnail: ImageView
            val textViewCardTitle: TextView
            val textViewCardCost: TextView

            init {
                imageViewCardThumbnail = rowBinding.imageViewCardThumbnail
                textViewCardTitle = rowBinding.textViewCardTitle
                textViewCardCost = rowBinding.textViewCardCost
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val rowBinding = RowProductCardBinding.inflate(layoutInflater)
            val holder = Holder(rowBinding)

            rowBinding.root.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            return holder
        }

        override fun getItemCount(): Int {
            return 10
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.textViewCardTitle.text = "${position+1} 번째 사료"
            holder.textViewCardCost.text = "${position+1}0000원"
        }
    }
}